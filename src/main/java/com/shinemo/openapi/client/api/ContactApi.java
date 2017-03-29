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
import com.shinemo.openapi.client.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

import static com.shinemo.openapi.client.common.Const.CONTENT_TYPE_HEADER;
import static com.shinemo.openapi.client.common.Const.USER_AGENT_HEADER;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public interface ContactApi {

    /**
     * 获取某个部门下的用户列表
     *
     * @param orgId       要访问的企业ID
     * @param deptId      部门ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return ContactDTO
     */
    @GET("user/list")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<ContactDTO>> listUsers(@Header("orgId") long orgId, @Query("deptId") long deptId, @Query("accessToken") String accessToken);

    /**
     * 创建用户
     *
     * @param orgId       要访问的企业ID
     * @param userDTO     要创建的用户
     * @param accessToken 通过getAccessToken方法获取的token
     * @return UidDTO
     */
    @POST("user/create")
    @Headers({USER_AGENT_HEADER, CONTENT_TYPE_HEADER})
    Call<OpenApiResult<UidDTO>> createUser(@Header("orgId") long orgId, @Body ContactUserDTO userDTO, @Query("accessToken") String accessToken);

    /**
     * 修改用户
     *
     * @param orgId       要访问的企业ID
     * @param userDTO     要修改的用户
     * @param accessToken 通过getAccessToken方法获取的token
     * @return UidDTO
     */
    @POST("user/update")
    @Headers({USER_AGENT_HEADER, CONTENT_TYPE_HEADER})
    Call<OpenApiResult<UidDTO>> updateUser(@Header("orgId") long orgId, @Body ContactUserDTO userDTO, @Query("accessToken") String accessToken);

    /**
     * 删除用户
     *
     * @param orgId       要访问的企业ID
     * @param userDTO     要删除的用户
     * @param accessToken 通过getAccessToken方法获取的token
     * @return 0表示操作成功
     */
    @POST("user/delete")
    @Headers({USER_AGENT_HEADER, CONTENT_TYPE_HEADER})
    Call<OpenApiResult<Long>> deleteUser(@Header("orgId") long orgId, @Body ContactUserDTO userDTO, @Query("accessToken") String accessToken);


    /**
     * 获取某个部门下的用户列表
     *
     * @param orgId       要访问的企业ID
     * @param deptId      部门ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return ContactDTO
     */
    @GET("department/list")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<ContactDTO>> listDepts(@Header("orgId") long orgId, @Query("deptId") long deptId, @Query("accessToken") String accessToken);

    /**
     * 创建用户
     *
     * @param orgId       要访问的企业ID
     * @param deptDTO     要创建的部门
     * @param accessToken 通过getAccessToken方法获取的token
     * @return UidDTO
     */
    @POST("department/create")
    @Headers({USER_AGENT_HEADER, CONTENT_TYPE_HEADER})
    Call<OpenApiResult<DeptIdDTO>> createDept(@Header("orgId") long orgId, @Body ContactDeptDTO deptDTO, @Query("accessToken") String accessToken);

    /**
     * 修改用户
     *
     * @param orgId       要访问的企业ID
     * @param deptDTO     要修改的部门
     * @param accessToken 通过getAccessToken方法获取的token
     * @return UidDTO
     */
    @POST("department/update")
    @Headers({USER_AGENT_HEADER, CONTENT_TYPE_HEADER})
    Call<OpenApiResult<DeptIdDTO>> updateDept(@Header("orgId") long orgId, @Body ContactDeptDTO deptDTO, @Query("accessToken") String accessToken);

    /**
     * 删除用户
     *
     * @param orgId       要访问的企业ID
     * @param deptDTO     要删除的部门
     * @param accessToken 通过getAccessToken方法获取的token
     * @return 0表示操作成功
     */
    @POST("department/delete")
    @Headers({USER_AGENT_HEADER, CONTENT_TYPE_HEADER})
    Call<OpenApiResult<Long>> deleteDept(@Header("orgId") long orgId, @Body ContactDeptDTO deptDTO, @Query("accessToken") String accessToken);

}
