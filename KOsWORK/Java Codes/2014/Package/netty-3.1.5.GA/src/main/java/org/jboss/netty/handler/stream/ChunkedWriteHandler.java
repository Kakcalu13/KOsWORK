/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.handler.stream;

import static org.jboss.netty.channel.Channels.*;

import java.util.Queue;

import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/**
 * A {@link ChannelHandler} that adds support for writing a large data stream
 * asynchronously neither spending a lot of memory nor getting
 * {@link java.lang.OutOfMemoryError}.  Large data streaming such as file
 * transfer requires complicated state management in a {@link ChannelHandler}
 * implementation.  {@link ChunkedWriteHandler} manages such complicated states
 * so that you can send a large data stream without difficulties.
 * <p>
 * To use {@link ChunkedWriteHandler} in your application, you have to insert
 * a new {@link ChunkedWriteHandler} instance:
 * <pre>
 * ChannelPipeline p = ...;
 * p.addLast("streamer", <b>new ChunkedWriteHandler()</b>);
 * p.addLast("handler", new MyHandler());
 * </pre>
 * Once inserted, you can write a {@link ChunkedInput} so that the
 * {@link ChunkedWriteHandler} can pick it up and fetch the content of the
 * stream chunk by chunk and write the fetched chunk downstream:
 * <pre>
 * Channel ch = ...;
 * ch.write(new ChunkedFile(new File("video.mkv"));
 * </pre>
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 *
 * @apiviz.landmark
 * @apiviz.has org.jboss.netty.handler.stream.ChunkedInput oneway - - reads from
 */
@ChannelPipelineCoverage("one")
public class ChunkedWriteHandler implements ChannelUpstreamHandler, ChannelDownstreamHandler {

    private static final InternalLogger logger =
        InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);

    private final Queue<MessageEvent> queue =
        new LinkedTransferQueue<MessageEvent>();

    private MessageEvent currentEvent;

    /**
     * Creates a new instance.
     */
    public ChunkedWriteHandler() {
        super();
    }

    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e)
            throws Exception {
        if (!(e instanceof MessageEvent)) {
            ctx.sendDownstream(e);
            return;
        }

        queue.offer((MessageEvent) e);
        if (ctx.getChannel().isWritable()) {
            flush(ctx);
        }
    }

    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e)
            throws Exception {
        if (e instanceof ChannelStateEvent) {
            ChannelStateEvent cse = (ChannelStateEvent) e;
            switch (cse.getState()) {
            case INTEREST_OPS:
                // Continue writing when the channel becomes writable.
                flush(ctx);
                break;
            case OPEN:
                if (!Boolean.TRUE.equals(cse.getValue())) {
                    // Fail all pending writes
                    discard(ctx);
                }
                break;
            }
        }
        ctx.sendUpstream(e);
    }

    private synchronized void discard(ChannelHandlerContext ctx) {
        for (;;) {
            if (currentEvent == null) {
                currentEvent = queue.poll();
            }

            if (currentEvent == null) {
                break;
            }

            MessageEvent currentEvent = this.currentEvent;
            this.currentEvent = null;

            Object m = currentEvent.getMessage();
            if (m instanceof ChunkedInput) {
                closeInput((ChunkedInput) m);

                // Trigger a ClosedChannelException
                Channels.write(
                        ctx, currentEvent.getFuture(), ChannelBuffers.EMPTY_BUFFER,
                        currentEvent.getRemoteAddress());
            } else {
                // Trigger a ClosedChannelException
                ctx.sendDownstream(currentEvent);
            }
            currentEvent = null;
        }
    }

    private synchronized void flush(ChannelHandlerContext ctx) throws Exception {
        final Channel channel = ctx.getChannel();
        if (!channel.isConnected()) {
            discard(ctx);
        }

        while (channel.isWritable()) {
            if (currentEvent == null) {
                currentEvent = queue.poll();
            }

            if (currentEvent == null) {
                break;
            }

            if (currentEvent.getFuture().isDone()) {
                // Skip the current request because the previous partial write
                // attempt for the current request has been failed.
                currentEvent = null;
            } else {
                Object m = currentEvent.getMessage();
                if (m instanceof ChunkedInput) {
                    ChunkedInput chunks = (ChunkedInput) m;
                    Object chunk;
                    boolean last;
                    try {
                        chunk = chunks.nextChunk();
                        if (chunk == null) {
                            chunk = ChannelBuffers.EMPTY_BUFFER;
                            last = true;
                        } else {
                            last = !chunks.hasNextChunk();
                        }
                    } catch (Throwable t) {
                        MessageEvent currentEvent = this.currentEvent;
                        this.currentEvent = null;

                        currentEvent.getFuture().setFailure(t);
                        fireExceptionCaught(ctx, t);

                        closeInput(chunks);
                        break;
                    }

                    ChannelFuture writeFuture;
                    final MessageEvent currentEvent = this.currentEvent;
                    if (last) {
                        this.currentEvent = null;
                        closeInput(chunks);
                        writeFuture = currentEvent.getFuture();
                    } else {
                        writeFuture = future(channel);
                        writeFuture.addListener(new ChannelFutureListener() {
                            public void operationComplete(ChannelFuture future)
                                    throws Exception {
                                if (!future.isSuccess()) {
                                    currentEvent.getFuture().setFailure(future.getCause());
                                    closeInput((ChunkedInput) currentEvent.getMessage());
                                }
                            }
                        });
                    }

                    Channels.write(
                            ctx, writeFuture, chunk,
                            currentEvent.getRemoteAddress());
                } else {
                    ctx.sendDownstream(currentEvent);
                    currentEvent = null;
                }
            }

            if (!channel.isConnected()) {
                discard(ctx);
                break;
            }
        }
    }

    static void closeInput(ChunkedInput chunks) {
        try {
            chunks.close();
        } catch (Throwable t) {
            logger.warn("Failed to close a chunked input.", t);
        }
    }
}
