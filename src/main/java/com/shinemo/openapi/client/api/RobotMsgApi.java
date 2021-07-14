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

package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.robot.RobotMessageDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
public interface RobotMsgApi {

    /**
     * 机器人推送群消息
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    推送消息
     * @return void
     */
    @POST("robot/push/group")
    Call<OpenApiResult<Void>> pushGroup(@HeaderMap Map<String, String> headers, @Body RobotMessageDTO body);

    /**
     * 机器人推给用户消息
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    推送消息
     * @return void
     */
    @POST("robot/push/user")
    Call<OpenApiResult<Void>> pushUser(@HeaderMap Map<String, String> headers, @Body RobotMessageDTO body);


}
