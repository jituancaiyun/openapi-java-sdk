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

import com.shinemo.openapi.client.api.PrivilegeGroupApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.PrivilegeGroupDTO;

import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(PrivilegeGroupApi.class)
public interface PrivilegeGroupApiService {

    /**
     * 创建权限组
     *
     * @param context 基础header参数, accessToken, orgId, uid
     * @param group   权限组信息
     * @return
     */
    OpenApiResult<Map<String, Long>> create(ApiContext context, PrivilegeGroupDTO group);

    /**
     * 删除权限去
     *
     * @param context 基础header参数, accessToken, orgId, uid
     * @param groupId 权限组id
     * @return
     */
    OpenApiResult<Long> delete(ApiContext context, Long groupId);

}
