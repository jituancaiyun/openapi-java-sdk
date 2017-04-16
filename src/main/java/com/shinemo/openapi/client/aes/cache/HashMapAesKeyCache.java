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
import com.shinemo.openapi.client.aes.db.AesKeyDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class HashMapAesKeyCache/* implements AesKeyCache */{
    private Map<Integer, AesKey> cache = new HashMap<Integer, AesKey>();

    private AesKeyDao aesKeyDao;

    public void init(){

    }

    public void setAesKeyDao(AesKeyDao aesKeyDao) {
        this.aesKeyDao = aesKeyDao;
    }

//    @Override
//    public List<AesKey> getListByIds(List<Integer> ids) {
//        return null;
//    }
//
//    @Override
//    public AesKey getById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<AesKey> getLatest(String orgId, int limit) {
//        return null;
//    }
}
