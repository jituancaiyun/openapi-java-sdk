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
import com.shinemo.openapi.client.dto.contact.Org;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public interface ContactApi {

    /**
     * 获取某个部门下的用户列表
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptId  部门ID
     * @return ContactDTO
     */
    @GET("user/list")
    Call<OpenApiResult<ContactDTO>> listUsers(@HeaderMap Map<String, String> headers, @Query("deptId") long deptId);

    /**
     * 获取某个部门下的所有用户（包含子部门用户）
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptId  部门ID
     * @return ContactDTO
     */
    @GET("user/list/all")
    Call<OpenApiResult<ContactDTO>> listUsersAll(@HeaderMap Map<String, String> headers, @Query("deptId") long deptId);

    /**
     * 获取某个部门下的所有用户（包含子部门用户）
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptId  部门ID
     * @return ContactDTO
     */
    @GET("user/detail")
    Call<OpenApiResult<ContactUserDTO>> detail(@HeaderMap Map<String, String> headers, @Query("uid") long uid, @Query("deptId") long deptId);

    /**
     * 创建用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param userDTO 要创建的用户
     * @return UidDTO
     */
    @POST("user/create")
    Call<OpenApiResult<UidDTO>> createUser(@HeaderMap Map<String, String> headers, @Body ContactUserDTO userDTO);

    /**
     * 修改用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param userDTO 要修改的用户
     * @return UidDTO
     */
    @POST("user/update")
    Call<OpenApiResult<UidDTO>> updateUser(@HeaderMap Map<String, String> headers, @Body ContactUserDTO userDTO);

    /**
     * 删除用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param userDTO 要删除的用户
     * @return 0表示操作成功
     */
    @POST("user/delete")
    Call<OpenApiResult<Long>> deleteUser(@HeaderMap Map<String, String> headers, @Body ContactUserDTO userDTO);


    /**
     * 获取某个部门下的用户列表
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptId  部门ID
     * @return ContactDTO
     */
    @GET("department/list")
    Call<OpenApiResult<ContactDTO>> listDepts(@HeaderMap Map<String, String> headers, @Query("deptId") long deptId);

    /**
     * 创建用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptDTO 要创建的部门
     * @return UidDTO
     */
    @POST("department/create")
    Call<OpenApiResult<DeptIdDTO>> createDept(@HeaderMap Map<String, String> headers, @Body ContactDeptDTO deptDTO);

    /**
     * 修改用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptDTO 要修改的部门
     * @return UidDTO
     */
    @POST("department/update")
    Call<OpenApiResult<DeptIdDTO>> updateDept(@HeaderMap Map<String, String> headers, @Body ContactDeptDTO deptDTO);

    /**
     * 删除用户
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param deptDTO 要删除的部门
     * @return 0表示操作成功
     */
    @POST("department/delete")
    Call<OpenApiResult<Long>> deleteDept(@HeaderMap Map<String, String> headers, @Body ContactDeptDTO deptDTO);

    @POST("contact/import")
    Call<OpenApiResult<Void>> contactImport(@HeaderMap Map<String, String> headers, @Body Org org);

    @GET("contact/export")
    Call<OpenApiResult<Org>> contactExport(@HeaderMap Map<String, String> headers);

}
