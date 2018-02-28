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

import com.shinemo.openapi.client.api.DepartmentApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(DepartmentApi.class)
public interface DepartmentApiService {

    /**
     * 创建部门
     *
     * @param apiContext  基础header参数, accessToken, orgSecret, uid
     * @param deptInfoDto 要创建的部门
     * @return UidDTO
     */
    OpenApiResult<Map<String, Long>> create(ApiContext apiContext, DeptInfoDTO deptInfoDto);

    /**
     * 删除部门
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param deptId     要删除的部门
     * @return 0表示操作成功
     */
    OpenApiResult<Void> delete(ApiContext apiContext, Long deptId);

    /**
     * 修改部门
     *
     * @param apiContext  基础header参数, accessToken, orgSecret, uid
     * @param deptInfoDTO 要修改的部门
     * @return UidDTO
     */
    OpenApiResult<Void> update(ApiContext apiContext, DeptInfoDTO deptInfoDTO);

    /**
     * 获取部门详情
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param deptId deptId
     * @return /
     */
    OpenApiResult<Map<String, DeptInfoDTO>> detail(ApiContext apiContext, Long deptId);

    /**
     * 获取某个部门下的部门列表
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param deptId     部门ID
     * @return ContactDTO
     */
    OpenApiResult<Map<String, List<DeptInfoDTO>>> deptList(ApiContext apiContext, Long deptId);

    /**
     * 获取部门下用户
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param deptId deptId
     * @return 用户列表
     */
    OpenApiResult<Map<String, List<UserInfoDTO>>> userList(ApiContext apiContext, Long deptId);

    /**
     * 获取当前部门和所有子部门下的用户
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param deptId deptId
     * @return 用户列表
     */
    OpenApiResult<Map<String, List<UserInfoDTO>>> userListAll(ApiContext apiContext, Long deptId);


}
