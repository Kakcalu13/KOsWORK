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
package org.jboss.netty.channel.socket.nio;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Daniel Bevenius (dbevenius@jboss.com)
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 */
@ChannelPipelineCoverage("all")
public class SimpleHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(final ChannelHandlerContext ctx,
            final MessageEvent e) throws Exception {
        final ChannelBuffer cb = (ChannelBuffer) e.getMessage();
        final byte[] actual = new byte[cb.readableBytes()];
        cb.getBytes(0, actual);
        //System.out.println("TestHandler payload : " + new String(actual));
        ctx.sendDownstream(e);
    }
}
