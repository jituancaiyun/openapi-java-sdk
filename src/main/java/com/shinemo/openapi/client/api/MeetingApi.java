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

import static com.shinemo.openapi.client.common.Const.USER_AGENT_HEADER;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
public interface MeetingApi {

    /**
     * 发起会议邀请
     *
     * @param orgId       要访问的企业ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return MeetingIdDTO 会议ID
     */
    @POST("workbench/meetinginvite/create")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<MeetingIdDTO>> createMeeting(@Header("orgId") String orgId, @Body MeetingInviteDTO body, @Query("accessToken") String accessToken);


    /**
     * 取消会议邀请
     *
     * @param orgId       要访问的企业ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return ContactDTO
     */
    @POST("workbench/meetinginvite/cancel")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<Long>> cancelMeeting(@Header("orgId") String orgId, @Body MeetingInviteDTO body, @Query("accessToken") String accessToken);


    /**
     * 删除会议邀请
     *
     * @param orgId       要访问的企业ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return ContactDTO
     */
    @POST("workbench/meetinginvite/delete")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<Long>> deleteMeeting(@Header("orgId") String orgId, @Body MeetingInviteDTO body, @Query("accessToken") String accessToken);


    /**
     * 修改会议邀请
     *
     * @param orgId       要访问的企业ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return ContactDTO
     */
    @POST("workbench/meetinginvite/update")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<Long>> updateMeeting(@Header("orgId") String orgId, @Body MeetingInviteDTO body, @Query("accessToken") String accessToken);


    /**
     * 修改会议邀请
     *
     * @param orgId       要访问的企业ID
     * @param accessToken 通过getAccessToken方法获取的token
     * @return ContactDTO
     */
    @GET("workbench/meetinginvite/detail")
    @Headers(USER_AGENT_HEADER)
    Call<OpenApiResult<Long>> getMeeting(@Header("orgId") String orgId, @Query("accessToken") String accessToken);

}
