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
import com.shinemo.openapi.client.dto.maillist.UserDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface UserApi {

    /**
     * 添加雇员
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @return void
     */
    @POST("employee/add")
    Call<OpenApiResult<Map<String, String>>> add(@HeaderMap Map<String, String> headers, @Body UserDTO body);

    @POST("employee/delete")
    Call<OpenApiResult<Long>> delete(@HeaderMap Map<String, String> headers, @Query("uid") String uid, @Query("deptId") Long deptId);

    @POST("employee/update")
    Call<OpenApiResult<Map<String, String>>> update(@HeaderMap Map<String, String> headers, @Body UserDTO body);

    @GET("employee/list")
    Call<OpenApiResult<List<UserInfoDTO>>> list(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @GET("employee/listAll")
    Call<OpenApiResult<List<UserInfoDTO>>> listAll(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @GET("employee/detail")
    Call<OpenApiResult<UserInfoDTO>> detail(@HeaderMap Map<String, String> headers, @Query("uid") String uid, @Query("deptId") Long deptId);

}
