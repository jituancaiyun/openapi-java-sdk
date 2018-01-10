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

import com.shinemo.openapi.client.api.TeamRemindApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.teamremind.TeamRemindDetailDTO;
import com.shinemo.openapi.client.dto.teamremind.TeamRemindInfoDTO;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(TeamRemindApi.class)
public interface TeamRemindApiService {

    /**
     * 创建团队提醒新接口
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param detail     团队提醒实体
     * @return
     */
    OpenApiResult<Map<String, Long>> create(ApiContext apiContext, TeamRemindDetailDTO detail);

    /**
     * 取消团队提醒新接口
     *
     * @param apiContext   基础header参数, accessToken, orgSecret, uid
     * @param teamRemindId 团队提醒id
     * @return
     */
    OpenApiResult<Long> cancel(ApiContext apiContext, Long teamRemindId);

    /**
     * 删除团队提醒新接口
     *
     * @param apiContext   基础header参数, accessToken, orgSecret, uid
     * @param teamRemindId 团队提醒id
     * @return
     */
    OpenApiResult<Long> delete(ApiContext apiContext, Long teamRemindId);

    /**
     * 更新团队提醒详情
     *
     * @param apiContext   基础header参数, accessToken, orgSecret, uid
     * @param teamRemindId 团队提醒id
     * @param detail       提醒详情
     * @return
     */
    OpenApiResult<Long> update(ApiContext apiContext, Long teamRemindId, TeamRemindDetailDTO detail);

    /**
     * 获取团队提醒详情新接口
     *
     * @param apiContext   基础header参数, accessToken, orgSecret, uid
     * @param teamRemindId 团队提醒id
     * @return
     */
    OpenApiResult<TeamRemindInfoDTO> detail(ApiContext apiContext, Long teamRemindId);
}
