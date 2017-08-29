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

import com.shinemo.openapi.client.api.UserApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.UserDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;
import retrofit2.Call;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(UserApi.class)
public interface UserApiService {

    /**
     * 新增用户
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @return void
     */
    OpenApiResult<Map<String, String>> add(ApiContext apiContext, UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param apiContext
     * @param uid
     * @param deptId
     * @return
     */
    OpenApiResult<Long> delete(ApiContext apiContext, String uid, Long deptId);

    /**
     * 更新用户
     *
     * @param apiContext
     * @param userDTO
     * @return
     */
    OpenApiResult<Map<String, String>> update(ApiContext apiContext, UserDTO userDTO);

    /**
     * 获取用户详情
     *
     * @param apiContext
     * @param uid
     * @param deptId
     * @return
     */
    OpenApiResult<Map<String, UserInfoDTO>> detail(ApiContext apiContext, String uid, Long deptId);

    /**
     * 获取用户所在部门列表
     * @param apiContext
     * @param deptId
     * @return
     */
    OpenApiResult<Map<String, List<DeptInfoDTO>>> deptList(ApiContext apiContext, Long deptId);

    @Deprecated
    OpenApiResult<Map<String, List<UserInfoDTO>>> list(ApiContext apiContext, Long deptId);

    @Deprecated
    OpenApiResult<Map<String, List<UserInfoDTO>>> listAll(ApiContext apiContext, Long deptId);


}
