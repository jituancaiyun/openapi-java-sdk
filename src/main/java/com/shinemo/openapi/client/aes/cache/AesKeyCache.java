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

import com.shinemo.openapi.client.aes.AesKey;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface AesKeyCache<K,V> {

//    List<AesKey> getListByIds(List<Integer> ids);
//
//    AesKey getById(int id);
//
//    List<AesKey> getLatest(String orgId, int limit);

    /**
     * 设置缓存
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * 一次设置多个缓存
     *
     * @param map
     */
    void putAll(Map<K, V> map);

    /**
     * 根据key的list数组批量获取缓存数据
     *
     * @param list
     * @return
     */
    Map<K,V> getAll(List<K> list);

    /**
     * 获取单个缓存数据
     *
     * @param key
     * @return
     */
    V get(K key);

}
