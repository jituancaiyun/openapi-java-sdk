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

package com.shinemo.openapi.client.aes;

import com.shinemo.openapi.client.aes.cache.AesKeyCache;
import com.shinemo.openapi.client.aes.cache.HashMapAesKeyCache;
import com.shinemo.openapi.client.aes.db.AesKeyDao;
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.common.OpenApiUtils;
import com.shinemo.openapi.client.service.AuthApiService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class DefaultAesKeyService implements AesKeyService {

    private int limit = 20;

    private AuthApiService authApiService;

    private AesKeyDao aesKeyDao;

    private AesKeyCache aesKeyCache;

    public void init() {

        if (authApiService == null) {
            throw new OpenApiException("authApiService can not be null.");
        }

        if (aesKeyDao == null) {
            throw new OpenApiException("aesKeyDao can not be null.");
        }

        if (aesKeyCache == null) {
            HashMapAesKeyCache guavaAesKeyCache = new HashMapAesKeyCache();
            guavaAesKeyCache.setAesKeyDao(aesKeyDao);
            guavaAesKeyCache.init();
            aesKeyCache = guavaAesKeyCache;
        }
    }

    @Override
    public AesKey getAesKeyBySDK(String orgId) {
        return getLatest(orgId, 1).get(0);
    }

    @Override
    public OpenApiResult<List<AesKeyEntity>> getAesKeyByClient(String orgId, String uid, String token, long timestamp, String keyIds) {

        if (orgId == null || uid == null || token == null) {
            return OpenApiResult.failure(400, "参数错误");
        }

        OpenApiResult<Void> result = authApiService.checkHttpToken(ApiContext.ctx(orgId, uid), token, timestamp);
        if (!result.isSuccess()) {
            return OpenApiResult.failure(403, "权限校验失败");
        }

        //如果keyIds为空, 查询最近的n条
        if (keyIds == null || keyIds.isEmpty()) {
            return OpenApiResult.success(getLatest(orgId, limit));
        } else {
            return OpenApiResult.success(getByIds(orgId, keyIds.split(",")));
        }
    }

    private List<AesKeyEntity> getByIds(String orgId, String[] keyIdArray) {
        List<Integer> list = new ArrayList<Integer>(keyIdArray.length);
        for (String id : keyIdArray) {
            list.add(Integer.parseInt(id));
        }
        return aesKeyCache.getListByKeyIds(orgId, list);
    }

    private List<AesKeyEntity> getLatest(String orgId, int limit) {
        return aesKeyCache.getLatestByOrgId(orgId, limit);
    }

    public void setAuthApiService(AuthApiService authApiService) {
        this.authApiService = authApiService;
    }

    public void setAesKeyDao(AesKeyDao aesKeyDao) {
        this.aesKeyDao = aesKeyDao;
    }

    public void setAesKeyCache(AesKeyCache aesKeyCache) {
        this.aesKeyCache = aesKeyCache;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
