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
import com.shinemo.openapi.client.dto.MeetingIdDTO;
import com.shinemo.openapi.client.dto.MeetingInviteDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
public interface MeetingApi {

    /**
     * 发起会议邀请
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    业务数据
     * @return MeetingIdDTO 会议ID
     */
    @POST("workbench/meetinginvite/create")
    Call<OpenApiResult<MeetingIdDTO>> createMeeting(@HeaderMap Map<String, String> headers, @Body MeetingInviteDTO body);


    /**
     * 取消会议邀请
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    业务数据
     * @return ContactDTO
     */
    @POST("workbench/meetinginvite/cancel")
    Call<OpenApiResult<Long>> cancelMeeting(@HeaderMap Map<String, String> headers, @Body MeetingInviteDTO body);


    /**
     * 删除会议邀请
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    业务数据
     * @return ContactDTO
     */
    @POST("workbench/meetinginvite/delete")
    Call<OpenApiResult<Long>> deleteMeeting(@HeaderMap Map<String, String> headers, @Body MeetingInviteDTO body);


    /**
     * 修改会议邀请
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    业务数据
     * @return ContactDTO
     */
    @POST("workbench/meetinginvite/update")
    Call<OpenApiResult<Long>> updateMeeting(@HeaderMap Map<String, String> headers, @Body MeetingInviteDTO body);


    /**
     * 修改会议邀请
     *
     * @param headers 基础header参数, accessToken, orgId, uid
     * @param body    业务数据
     * @return ContactDTO
     */
    @GET("workbench/meetinginvite/detail")
    Call<OpenApiResult<Long>> getMeeting(@HeaderMap Map<String, String> headers, @Body MeetingInviteDTO body);

}
