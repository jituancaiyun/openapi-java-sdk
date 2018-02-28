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

package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.api.AuthApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.UserInfoDTO;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(AuthApi.class)
public interface AuthApiService {

    /**
     * 免登接口
     *
     * @param authToken 客户端透传下来的授权token
     * @return UserInfoDTO
     */
    OpenApiResult<UserInfoDTO> login(String authToken);

    /**
     * 用户身份校验接口, 校验用户是否当前企业的合法用户
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param httpToken  用户身份token由客户端生成
     * @param timestamp  时间戳由客户端生成
     * @return result code
     */
    OpenApiResult<Void> checkHttpToken(ApiContext apiContext, String httpToken, long timestamp);

}
