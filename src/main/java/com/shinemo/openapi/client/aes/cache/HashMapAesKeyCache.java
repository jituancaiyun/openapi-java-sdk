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
import com.shinemo.openapi.client.common.OpenApiUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class HashMapAesKeyCache implements AesKeyCache {
    private final Map<Integer, AesKeyEntity> idCache = new ConcurrentHashMap<Integer, AesKeyEntity>();
    //Value 是个ArrayList要防止多线程问题
    private final Map<String, List<AesKeyEntity>> orgCache = new ConcurrentHashMap<String, List<AesKeyEntity>>();

    private AesKeyDao aesKeyDao;

    public void init() {

    }

    public void setAesKeyDao(AesKeyDao aesKeyDao) {
        this.aesKeyDao = aesKeyDao;
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

        if (notInCacheIds.size() > 0) {
            List<AesKeyEntity> keyListInDB = aesKeyDao.selectListByKeyIds(notInCacheIds);

            if (keyListInDB != null && keyListInDB.size() > 0) {
                for (AesKeyEntity entity : keyListInDB) {
                    result.add(entity);
                    idCache.put(entity.getId(), entity);
                }
            }
        }
        return result;
    }


    @Override
    public List<AesKeyEntity> getLatestByOrgId(String orgId, int limit) {
        //1.查询缓存中的数据
        List<AesKeyEntity> keysInCache = orgCache.get(orgId);
        //2.判断缓存中的第一个key是不是今天生成的
        if (keysInCache == null || keysInCache.isEmpty() || isNotToday(keysInCache.get(0).getGmtCreate())) {
            synchronized (this) {
                //创建一份新的缓存, (keysInCache不能进行写操作[unmodifiableList])
                List<AesKeyEntity> newCacheList = new ArrayList<AesKeyEntity>(limit + 1);

                //3.查询DB中是否有今天生成的key, 查一次DB是因为分布式部署下, 别的机器可能已经处理了
                List<AesKeyEntity> keysInDB = aesKeyDao.selectListByOrgId(orgId, limit);

                //4.判断db中的第一个key是不是今天生成的, 即别的机器有没有创建新key, 没有就创建一个新的
                if (keysInDB == null || keysInDB.isEmpty() || isNotToday(keysInDB.get(0).getGmtCreate())) {
                    //5.创建新key, 并加入到新的的cache list
                    AesKeyEntity newKey = createNewKey(orgId);
                    newCacheList.add(newKey);
                }

                //6. 把db中最新的key, 加入到缓存
                if (keysInDB != null) {
                    newCacheList.addAll(keysInDB);
                }

                //7. 更新缓存, 并且禁止修改缓存内容, 防止多线程出错
                keysInCache = Collections.unmodifiableList(newCacheList);
                orgCache.put(orgId, keysInCache);
            }
        }
        //不要直接返回list, 要复制一份数据防止线程安全问题
        return keysInCache;
    }

    private AesKeyEntity createNewKey(String orgId) {
        AesKeyEntity aesKeyEntity = new AesKeyEntity();
        aesKeyEntity.setOrgId(orgId);
        aesKeyEntity.setKey(OpenApiUtils.randomAesKey());
        aesKeyEntity.setGmtCreate(new Date().getTime());
        boolean success = aesKeyDao.insert(aesKeyEntity);
        return success ? aesKeyEntity : null;
    }

    private boolean isNotToday(Long date) {
        if (date == null) return false;
        Calendar now = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);

        return now.get(Calendar.YEAR) != cal.get(Calendar.YEAR)
                || now.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR);
    }
}
