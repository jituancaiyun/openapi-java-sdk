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
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AppMessageDTO;
import com.shinemo.openapi.client.dto.PushMessageDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static com.shinemo.openapi.client.common.Const.USER_AGENT_HEADER;

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
     * @param orgId      要访问的企业ID
     * @param messageDTO 消息详情
     * @return illegalUsers非法用户列表
     */
    OpenApiResult<List<String>> sendPushMessage(String orgId, PushMessageDTO messageDTO);

}
