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
package org.jboss.netty.buffer;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 */
public class SlicedChannelBufferTest extends AbstractChannelBufferTest {

    private final Random random = new Random();
    private ChannelBuffer buffer;

    @Override
    protected ChannelBuffer newBuffer(int length) {
        buffer = ChannelBuffers.wrappedBuffer(
                new byte[length * 2], random.nextInt(length - 1) + 1, length);
        assertEquals(length, buffer.writerIndex());
        return buffer;
    }

    @Override
    protected ChannelBuffer[] components() {
        return new ChannelBuffer[] { buffer };
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowNullInConstructor() {
        new SlicedChannelBuffer(null, 0, 0);
    }
}
