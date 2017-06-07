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
import com.shinemo.openapi.client.dto.meeting.MeetingInviteDetailDTO;
import com.shinemo.openapi.client.dto.teamremind.TeamRemindDetailDTO;
import com.shinemo.openapi.client.dto.teamremind.TeamRemindInfoDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
public interface TeamRemindApi {

    /**
     * 创建团队提醒新接口
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    业务数据
     * @return
     */
    @POST("teamremind/create")
    Call<OpenApiResult<Map<String, Long>>> create(@HeaderMap Map<String, String> headers, @Body TeamRemindDetailDTO body);

    /**
     * 取消团队提醒新接口
     *
     * @param headers      基础header参数, accessToken, orgId, uid
     * @param teamRemindId 团队提醒id
     * @return
     */
    @POST("teamremind/cancel")
    Call<OpenApiResult<Long>> cancel(@HeaderMap Map<String, String> headers, @Query("teamRemindId") Long teamRemindId);

    /**
     * 删除团队提醒新接口
     *
     * @param headers      基础header参数, accessToken, orgId, uid
     * @param teamRemindId 团队提醒id
     * @return
     */
    @POST("teamremind/delete")
    Call<OpenApiResult<Long>> delete(@HeaderMap Map<String, String> headers, @Query("teamRemindId") Long teamRemindId);

    /**
     * 修改团队提醒新接口
     *
     * @param headers      基础header参数, accessToken, orgId, uid
     * @param teamRemindId 团队提醒id
     * @param detail       团队提醒实体信息
     * @return
     */
    @POST("teamremind/update")
    Call<OpenApiResult<Long>> update(@HeaderMap Map<String, String> headers, @Query("teamRemindId") Long teamRemindId, @Body MeetingInviteDetailDTO detail);

    /**
     * 团队提醒详情新接口
     *
     * @param headers      基础header参数, accessToken, orgId, uid
     * @param teamRemindId 团队提醒id
     * @return
     */
    @GET("teamremind/detail")
    Call<OpenApiResult<TeamRemindInfoDTO>> detail(@HeaderMap Map<String, String> headers, @Query("teamRemindId") Long teamRemindId);

}
