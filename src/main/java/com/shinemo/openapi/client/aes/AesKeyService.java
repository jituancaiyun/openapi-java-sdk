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
import com.shinemo.openapi.client.aes.db.AesKeyDao;
import com.shinemo.openapi.client.aes.domain.AesKeyDTO;
import com.shinemo.openapi.client.aes.domain.ResultMsg;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.service.AuthApiService;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface AesKeyService {

    AesKey getAesKeyOfTodayBySDK(long orgId) throws Exception;

    ResultMsg<Map<String,List<AesKeyDTO>>> getAesKeyByClient(String token, String uid, long timestamp, long orgId, String keyIds) throws Exception;

    void setOpenApiClient(OpenApiClient openApiClient) ;

    void setAuthApiService(AuthApiService authApiService);

    void setAesKeyDao(AesKeyDao aesKeyDao);

    void setAesKeyCacheId(AesKeyCache<String,AesKeyDTO> aesKeyCache);

    void setAesKeyCacheOrgId(AesKeyCache<Long,Map<String,String>> aesKeyCacheOrgId);

    void setCacheDays(Integer cacheDays);

    void init();

}
