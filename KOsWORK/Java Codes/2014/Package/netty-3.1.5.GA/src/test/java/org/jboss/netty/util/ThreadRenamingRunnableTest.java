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
package org.jboss.netty.util;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.security.Permission;
import java.util.concurrent.Executor;

import org.jboss.netty.util.internal.ImmediateExecutor;
import org.junit.Test;


/**
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 *
 */
public class ThreadRenamingRunnableTest {

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowNullName() throws Exception {
        new ThreadRenamingRunnable(createMock(Runnable.class), null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowNullRunnable() throws Exception {
        new ThreadRenamingRunnable(null, "foo");
    }

    @Test
    public void testWithoutSecurityManager() throws Exception {
        final String oldThreadName = Thread.currentThread().getName();
        Executor e = ImmediateExecutor.INSTANCE;
        e.execute(new ThreadRenamingRunnable(
                new Runnable() {
                    public void run() {
                        assertEquals("foo", Thread.currentThread().getName());
                        assertFalse(oldThreadName.equals(Thread.currentThread().getName()));
                    }
                }, "foo"));

        assertEquals(oldThreadName, Thread.currentThread().getName());
    }

    @Test
    public void testWithSecurityManager() throws Exception {
        final String oldThreadName = Thread.currentThread().getName();
        Executor e = ImmediateExecutor.INSTANCE;
        System.setSecurityManager(new SecurityManager() {

            @Override
            public void checkAccess(Thread t) {
                throw new SecurityException();
            }

            @Override
            public void checkPermission(Permission perm, Object context) {
                // Allow
            }

            @Override
            public void checkPermission(Permission perm) {
                // Allow
            }
        });
        try {
            e.execute(new ThreadRenamingRunnable(
                    new Runnable() {
                        public void run() {
                            assertEquals(oldThreadName, Thread.currentThread().getName());
                        }
                    }, "foo"));
        } finally {
            System.setSecurityManager(null);
            assertEquals(oldThreadName, Thread.currentThread().getName());
        }
    }
}
