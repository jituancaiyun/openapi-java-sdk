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

import com.shinemo.openapi.client.aes.db.AesKeyDao;
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class HashMapAesKeyCache implements AesKeyCache {
    private final Map<Integer, AesKeyEntity> idCache = new ConcurrentHashMap<Integer, AesKeyEntity>();
    private final Map<String, List<AesKeyEntity>> orgCache = new ConcurrentHashMap<String, List<AesKeyEntity>>();

    private AesKeyDao aesKeyDao;

    public void init() {

    }

    public void setAesKeyDao(AesKeyDao aesKeyDao) {
        this.aesKeyDao = aesKeyDao;
    }

    @Override
    public void addAesKey(String orgId, AesKeyEntity entity) {
        List<AesKeyEntity> list = orgCache.get(orgId);
        if (list == null) {
            list = new ArrayList<AesKeyEntity>();
            orgCache.put(orgId, list);
        }
        list.set(0, entity);
    }

    @Override
    public AesKeyEntity getById(int id) {
        AesKeyEntity aesKeyInCache = idCache.get(id);
        if (aesKeyInCache != null) {
            return aesKeyInCache;
        }

        AesKeyEntity aesKeyInDB = aesKeyDao.getById(id);

        if (aesKeyInDB != null) {
            idCache.put(aesKeyInDB.getId(), aesKeyInDB);
        }

        return aesKeyInDB;
    }


    @Override
    public List<AesKeyEntity> getListByKeyIds(String orgId, List<Integer> ids) {

        List<AesKeyEntity> result = new ArrayList<AesKeyEntity>(ids.size());
        List<Integer> notInCacheIds = new ArrayList<Integer>();

        for (Integer id : ids) {
            AesKeyEntity aesKeyEntity = idCache.get(id);
            if (aesKeyEntity != null) {
                result.add(aesKeyEntity);
            } else {
                notInCacheIds.add(id);
            }
        }

        List<AesKeyEntity> keyListInDB = aesKeyDao.selectListByKeyIds(notInCacheIds);

        if (keyListInDB != null && keyListInDB.size() > 0) {
            for (AesKeyEntity entity : keyListInDB) {
                result.add(entity);
                idCache.put(entity.getId(), entity);
            }
        }
        return result;
    }


    @Override
    public List<AesKeyEntity> getLatestByOrgId(String orgId, int limit) {
        List<AesKeyEntity> list = orgCache.get(orgId);
        if (list == null || list.size() < limit) {
            list = aesKeyDao.selectListByOrgId(orgId, limit);
            if (list != null) {
                orgCache.put(orgId, list);
            }
        }
        return list;
    }
}
