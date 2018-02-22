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

import com.shinemo.openapi.client.api.MessageApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.PushMessageDTO;
import com.shinemo.openapi.client.dto.message.AppMessage;

import java.util.List;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(MessageApi.class)
public interface MessageApiService {

    /**
     * 推送应用消息
     *
     * @param apiContext 基础header参数, accessToken, orgSecret, uid
     * @param messageDTO 消息详情
     * @return illegalUsers非法用户列表
     */
    OpenApiResult<List<String>> sendPushMessage(ApiContext apiContext, PushMessageDTO messageDTO);

    /**
     * 发送应用消息-简单
     * @param apiContext
     * @param messageDTO
     * @return
     */
    OpenApiResult<Void> sendAppMessage(ApiContext apiContext, PushMessageDTO messageDTO);

}
