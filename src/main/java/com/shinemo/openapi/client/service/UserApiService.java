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
import com.shinemo.openapi.client.dto.UserMobile;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.UserDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;

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
     * @param apiContext apiContext
     * @param userDTO    userDTO
     * @return /
     */
    OpenApiResult<Map<String, String>> add(ApiContext apiContext, UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param apiContext apiContext
     * @param uid        uid
     * @param deptId     deptId
     * @return void
     */
    OpenApiResult<Void> delete(ApiContext apiContext, String uid, Long deptId);

    /**
     * 更新用户
     *
     * @param apiContext apiContext
     * @param userDTO    userDTO
     * @return uid uid
     */
    OpenApiResult<Map<String, String>> update(ApiContext apiContext, UserDTO userDTO);

    /**
     * 获取用户详情
     *
     * @param apiContext apiContext
     * @param uid        uid
     * @param deptId     deptId
     * @return 用户信息
     */
    OpenApiResult<Map<String, UserInfoDTO>> detail(ApiContext apiContext, String uid, Long deptId);

    /**
     * 查询用户信息，uid、loginId、userId必须传一个
     *
     * @param context apiContext
     * @param param   动态参数，uid(彩云用户uid)、loginId(用户登录id，一般为手机号)、userId(开发者所在系统内用户id)中的一个
     * @return 用户信息
     */
    OpenApiResult<UserDTO> getUserInfo(ApiContext context, Map<String, String> param);

    /**
     * 根据uid查询用户信息
     *
     * @param apiContext apiContext
     * @param uids       uids
     * @return 用户信息
     */
    OpenApiResult<Map<String, UserDTO>> getUserInfoByUid(ApiContext apiContext, String uids);

    /**
     * 获取用户所在部门列表
     *
     * @param apiContext apiContext
     * @param uid        uid
     * @return 部门信息
     */
    OpenApiResult<Map<String, List<DeptInfoDTO>>> deptList(ApiContext apiContext, String uid);

    /**
     * 根据手机号获取用户信息
     *
     * @param apiContext apiContext
     * @param mobile     mobile
     * @return 用户信息
     */
    OpenApiResult<UserDTO> getUserInfoByMobile(ApiContext apiContext, String mobile);

    /**
     * 根据手机号获取uid，支持批量
     *
     * @param apiContext    apiContext
     * @param mobiles，多个手机号 "," 分隔
     * @return UserMobile列表
     */
    OpenApiResult<List<UserMobile>> getUidByMobile(ApiContext apiContext, String mobiles);

    @Deprecated
    OpenApiResult<Map<String, List<UserInfoDTO>>> list(ApiContext apiContext, Long deptId);

    @Deprecated
    OpenApiResult<Map<String, List<UserInfoDTO>>> listAll(ApiContext apiContext, Long deptId);


}
