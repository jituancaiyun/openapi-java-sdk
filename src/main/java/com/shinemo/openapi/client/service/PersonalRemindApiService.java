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

import com.shinemo.openapi.client.api.PersonalRemindApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.PersonalRemindDTO;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(PersonalRemindApi.class)
public interface PersonalRemindApiService {

    /**
     * 创建个人提醒
     *
     * @param apiContext     基础header参数, accessToken, orgId, uid
     * @param personalRemind 个人提醒详情
     */
    OpenApiResult<Map<String, Long>> create(ApiContext apiContext, PersonalRemindDTO.PersonalRemind personalRemind);

    OpenApiResult<Long> update(ApiContext apiContext, long personalRemindId, PersonalRemindDTO.PersonalRemind personalRemind);

    OpenApiResult<Long> delete(ApiContext apiContext, long personalRemindId);

    OpenApiResult<PersonalRemindDTO> detail(ApiContext apiContext, long personalRemindId);

}
