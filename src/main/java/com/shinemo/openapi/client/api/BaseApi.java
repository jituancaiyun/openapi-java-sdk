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
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.shinemo.openapi.client.common.Const.USER_AGENT_HEADER;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public interface BaseApi {

    /**
     * 获取accessToken
     *
     * @param appId     应用ID
     * @param appSecret 应用密钥
     * @param flags     表示0:不强制刷新, 1:强制刷新, 服务端默认是1
     * @return AccessTokenDTO
     */
    @GET("token/get")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<AccessTokenDTO>> getAccessToken(@Query("appId") String appId, @Query("appSecret") String appSecret, @Query("flags") int flags);

    /**
     * 免登接口
     *
     * @param authToken   客户端透传下来的授权token
     * @param accessToken 通过getAccessToken方法获取的token
     * @return UserInfoDTO
     */
    @GET("auth/getUserInfoByToken")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<UserInfoDTO>> login(@Query("token") String authToken, @Query("accessToken") String accessToken);

}
