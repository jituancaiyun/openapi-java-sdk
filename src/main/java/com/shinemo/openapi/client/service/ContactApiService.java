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

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.api.ContactApi;
import com.shinemo.openapi.client.dto.*;
import com.shinemo.openapi.client.common.Api;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(ContactApi.class)
public interface ContactApiService {

    /**
     * 获取某个部门下的用户列表
     *
     * @param orgId  要访问的企业ID
     * @param deptId 部门ID
     * @return ContactDTO
     */
    OpenApiResult<ContactDTO> listUsers(String orgId, long deptId);

    /**
     * 创建用户
     *
     * @param orgId   要访问的企业ID
     * @param userDTO 要创建的用户
     * @return UidDTO
     */
    OpenApiResult<UidDTO> createUser(String orgId, ContactUserDTO userDTO);

    /**
     * 修改用户
     *
     * @param orgId   要访问的企业ID
     * @param userDTO 要修改的用户
     * @return UidDTO
     */
    OpenApiResult<UidDTO> updateUser(String orgId, ContactUserDTO userDTO);

    /**
     * 删除用户
     *
     * @param orgId   要访问的企业ID
     * @param userDTO 要删除的用户
     * @return 0表示操作成功
     */
    OpenApiResult<Long> deleteUser(String orgId, ContactUserDTO userDTO);

    /**
     * 获取某个部门下的用户列表
     *
     * @param orgId  要访问的企业ID
     * @param deptId 部门ID
     * @return ContactDTO
     */
    OpenApiResult<ContactDTO> listDepts(String orgId, long deptId);

    /**
     * 创建用户
     *
     * @param orgId   要访问的企业ID
     * @param deptDTO 要创建的部门
     * @return UidDTO
     */
    OpenApiResult<DeptIdDTO> createDept(String orgId, ContactDeptDTO deptDTO);

    /**
     * 修改用户
     *
     * @param orgId   要访问的企业ID
     * @param deptDTO 要修改的部门
     * @return UidDTO
     */
    OpenApiResult<DeptIdDTO> updateDept(String orgId, ContactDeptDTO deptDTO);

    /**
     * 删除用户
     *
     * @param orgId   要访问的企业ID
     * @param deptDTO 要删除的部门
     * @return 0表示操作成功
     */
    OpenApiResult<Long> deleteDept(String orgId, ContactDeptDTO deptDTO);

}
