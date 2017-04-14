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

import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.aes.cache.AesKeyCache;
import com.shinemo.openapi.client.aes.cache.HashMapAesKeyCache;
import com.shinemo.openapi.client.aes.db.AesKeyDao;
import com.shinemo.openapi.client.aes.db.MysqlAesKeyDao;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.service.AuthApiService;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class DefaultAesKeyService implements AesKeyService {

    private DataSource dataSource;

    private OpenApiClient openApiClient;

    private AuthApiService authApiService;

    private AesKeyDao aesKeyDao;

    private AesKeyCache aesKeyCache;

    public void init() {
        if (dataSource == null) {
            throw new OpenApiException("dataSource can not be null.");
        }

        if (openApiClient == null) {
            throw new OpenApiException("openApiClient can not be null.");
        }


        if (authApiService == null) {
            throw new OpenApiException("authApiService can not be null.");
        }

        if (aesKeyDao == null) {
            MysqlAesKeyDao mysqlAesKeyDao = new MysqlAesKeyDao();
            mysqlAesKeyDao.setDataSource(dataSource);
            mysqlAesKeyDao.init();
            aesKeyDao = mysqlAesKeyDao;
        }

        if (aesKeyCache == null) {
            HashMapAesKeyCache hashMapAesKeyCache = new HashMapAesKeyCache();
            hashMapAesKeyCache.setAesKeyDao(aesKeyDao);
            hashMapAesKeyCache.init();
            aesKeyCache = hashMapAesKeyCache;
        }
    }

    @Override
    public AesKey getAesKeyBySDK(String orgId) {
        return null;
    }

    @Override
    public OpenApiResult<List<AesKey>> getAesKeyByClient(String token, String uid, long timestamp, String orgId, String keyIds) {
        OpenApiResult<Void> result = authApiService.checkHttpToken(token, timestamp, uid, orgId);
        if (!result.isSuccess()) {
            return OpenApiResult.failure(403, "权限校验失败");
        }


        return null;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setOpenApiClient(OpenApiClient openApiClient) {
        this.openApiClient = openApiClient;
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
}
