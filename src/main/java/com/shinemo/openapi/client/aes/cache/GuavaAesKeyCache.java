/*
 * (C) Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.shinemo.openapi.client.aes.cache;

import com.google.common.cache.LoadingCache;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class GuavaAesKeyCache<K,V> implements AesKeyCache<K,V> {
    private LoadingCache<K, V> cache;

    public GuavaAesKeyCache(LoadingCache<K, V> cache) {
        this.cache = cache;
    }

    @Override
    public void put(K key, V value) {
        cache.put(key,value);
    }

    @Override
    public void putAll(Map<K, V> map) {
        cache.putAll(map);
    }

    @Override
    public Map<K,V> getAll(List<K> list) {
        return cache.getAllPresent(list);
    }

    @Override
    public V get(K key) {
        return cache.getIfPresent(key);
    }
}
