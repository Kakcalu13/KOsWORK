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

/**
 * A utility class that provides the convenient shutdown of
 * {@link ExternalResourceReleasable}s.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 */
public class ExternalResourceUtil {

    /**
     * Releases the specified {@link ExternalResourceReleasable}s.
     */
    public static void release(ExternalResourceReleasable... releasables) {
        ExternalResourceReleasable[] releasablesCopy =
            new ExternalResourceReleasable[releasables.length];

        for (int i = 0; i < releasables.length; i ++) {
            if (releasables[i] == null) {
                throw new NullPointerException("releasables[" + i + "]");
            }
            releasablesCopy[i] = releasables[i];
        }

        for (ExternalResourceReleasable e: releasablesCopy) {
            e.releaseExternalResources();
        }
    }

    private ExternalResourceUtil() {
        super();
    }
}
