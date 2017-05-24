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

import com.shinemo.openapi.client.api.MatterNoticeApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.TeamRemindInfo;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(MatterNoticeApi.class)
public interface MatterNoticeApiService {

    /**
     * 创建个人提醒
     *
     * @param apiContext       基础header参数, accessToken, orgId, uid
     * @param teamRemindDetail 个人提醒详情
     */
    OpenApiResult<Map<String, Long>> create(ApiContext apiContext, TeamRemindInfo.TeamRemindDetail teamRemindDetail);

    OpenApiResult<Long> update(ApiContext apiContext, long personalRemindId, TeamRemindInfo.TeamRemindDetail teamRemindDetail);

    OpenApiResult<TeamRemindInfo> detail(ApiContext apiContext, long noticeId);

    OpenApiResult<Long> cancel(ApiContext apiContext, long noticeId);

    OpenApiResult<Long> delete(ApiContext apiContext, long noticeId);

    OpenApiResult<Long> open(ApiContext apiContext, long noticeId);

    OpenApiResult<Long> close(ApiContext apiContext, long noticeId);

}