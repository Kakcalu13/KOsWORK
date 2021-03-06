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
package org.jboss.netty.util.internal;

import static org.junit.Assert.*;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;


/**
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 *
 */
public class MapUtilTest {

    static {
        Logger logger = Logger.getLogger(MapUtil.class.getName());
        logger.setLevel(Level.ALL);
    }

    @Test
    public void shouldReturnTrueIfLinkedHashMap() {
        assertTrue(MapUtil.isOrderedMap(new LinkedHashMap<String, String>()));
    }

    @Test
    public void shouldReturnTrueIfMapImplementsOrderedMap() {
        assertTrue(MapUtil.isOrderedMap(new DummyOrderedMap<String, String>()));
    }

    @Test
    public void shouldReturnFalseIfMapHasNoDefaultConstructor() {
        assertFalse(MapUtil.isOrderedMap(
                new MapWithoutDefaultConstructor<String, String>(
                        new HashMap<String, String>())));
    }

    @Test
    public void shouldReturnFalseIfMapIsNotOrdered() {
        assertFalse(MapUtil.isOrderedMap(new HashMap<String, String>()));
    }

    @Test
    public void shouldReturnTrueIfMapIsOrdered() {
        assertTrue(MapUtil.isOrderedMap(new UnknownOrderedMap<String, String>()));
    }

    interface OrderedMap {
        // A tag interface
    }

    static class DummyOrderedMap<K,V> extends AbstractMap<K, V> implements OrderedMap {

        private final Map<K, V> map = new HashMap<K, V>();

        @Override
        public Set<Entry<K, V>> entrySet() {
            return map.entrySet();
        }
    }

    static class MapWithoutDefaultConstructor<K, V> extends AbstractMap<K, V> {
        private final Map<K, V> map;

        MapWithoutDefaultConstructor(Map<K, V> map) {
            this.map = map;
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            return map.entrySet();
        }
    }

    static class UnknownOrderedMap<K,V> extends AbstractMap<K, V> {

        private final Map<K, V> map = new LinkedHashMap<K, V>();

        @Override
        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public V put(K key, V value) {
            return map.put(key, value);
        }

        @Override
        public Set<K> keySet() {
            return map.keySet();
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            return map.entrySet();
        }
    }
}
