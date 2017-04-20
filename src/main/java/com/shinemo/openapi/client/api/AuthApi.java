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

package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;

import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface AuthApi {

    /**
     * 免登接口
     *
     * @param headers   基础header参数, accessToken, orgId, uid
     * @param authToken 客户端透传下来的授权token
     * @return UserInfoDTO
     */
    @GET("auth/getUserInfoByToken")
    Call<OpenApiResult<UserInfoDTO>> login(@HeaderMap Map<String, String> headers, @Header("token") String authToken);

    /**
     * 用户身份校验接口, 校验用户是否当前企业的合法用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @return void
     */
    @GET("auth/checkHttpToken")
    Call<OpenApiResult<Void>> checkHttpToken(@HeaderMap Map<String, String> headers, @Header("token") String httpToken, @Header("timestamp") long timestamp);

}
