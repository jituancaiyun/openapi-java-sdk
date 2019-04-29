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
import com.shinemo.openapi.client.dto.schedule.ScheduleDetail;
import com.shinemo.openapi.client.dto.schedule.ScheduleShareInfo;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by ohun on 2018/12/05.
 *
 * @author ohun@live.cn (夜色)
 */
public interface ScheduleApi {

    /**
     * 创建个人提醒
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    推送消息
     */
    @POST("schedule/add")
    Call<OpenApiResult<Long>> add(@HeaderMap Map<String, String> headers, @Body ScheduleDetail body);

    /**
     * 更新个人提醒
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    推送消息
     * @return
     */
    @POST("schedule/update")
    Call<OpenApiResult<Map<String, Long>>> update(@HeaderMap Map<String, String> headers, @Query("scheduleId") long scheduleId, @Body ScheduleDetail body);

    /**
     * 删除个人提醒
     *
     * @param headers    基础header参数, accessToken, orgId, uid
     * @param scheduleId 个人提醒id
     * @return
     */
    @POST("schedule/delete")
    Call<OpenApiResult<Void>> delete(@HeaderMap Map<String, String> headers, @Query("scheduleId") long scheduleId);

    /**
     * 获取个人提醒详情
     *
     * @param headers    基础header参数, accessToken, orgId, uid
     * @param scheduleId 个人提醒id
     * @return
     */
    @GET("schedule/detail")
    Call<OpenApiResult<ScheduleShareInfo>> detail(@HeaderMap Map<String, String> headers, @Query("scheduleId") long scheduleId);

}
