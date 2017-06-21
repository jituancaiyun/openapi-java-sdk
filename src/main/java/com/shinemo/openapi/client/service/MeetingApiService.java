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

import com.shinemo.openapi.client.api.MeetingApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MeetingIdDTO;
import com.shinemo.openapi.client.dto.MeetingInviteDTO;
import com.shinemo.openapi.client.dto.meeting.MeetingInviteDetailDTO;
import com.shinemo.openapi.client.dto.meeting.MeetingInviteInfoDTO;

import java.util.Map;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(MeetingApi.class)
public interface MeetingApiService {

    /**
     * 发起会议邀请
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingDTO 会议实体
     * @return MeetingIdDTO 会议ID
     */
    @Deprecated
    OpenApiResult<MeetingIdDTO> createMeeting(ApiContext apiContext, MeetingInviteDTO meetingDTO);

    /**
     * 取消会议邀请
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingDTO 会议实体
     * @return result code
     */
    @Deprecated
    OpenApiResult<Long> cancelMeeting(ApiContext apiContext, MeetingInviteDTO meetingDTO);


    /**
     * 删除会议邀请
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingDTO 会议实体
     * @return result code
     */
    @Deprecated
    OpenApiResult<Long> deleteMeeting(ApiContext apiContext, MeetingInviteDTO meetingDTO);

    /**
     * 修改会议邀请
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingDTO 会议实体
     * @return result code
     */
    @Deprecated
    OpenApiResult<Long> updateMeeting(ApiContext apiContext, MeetingInviteDTO meetingDTO);

    /**
     * 会议邀请详情
     *
     * @param apiContext       基础header参数, accessToken, orgId, uid
     * @param meetingInviteDTO 会议信息，包含会议id
     * @return result code
     */
    @Deprecated
    OpenApiResult<MeetingInviteDTO> getMeeting(ApiContext apiContext, MeetingInviteDTO meetingInviteDTO);

    /**
     * 创建会议新接口
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param detail     会议实体
     * @return
     */
    OpenApiResult<Map<String, Long>> create(ApiContext apiContext, MeetingInviteDetailDTO detail);

    /**
     * 取消会议新接口
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingId 会议id
     * @return
     */
    OpenApiResult<Long> cancel(ApiContext apiContext, Long meetingId);

    /**
     * 删除会议新接口
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingId 会议id
     * @return
     */
    OpenApiResult<Long> delete(ApiContext apiContext, Long meetingId);

    /**
     * 更新会议邀请详情
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingId 会议id
     * @return
     */
    OpenApiResult<Long> update(ApiContext apiContext, Long meetingId, MeetingInviteDetailDTO detail);

    /**
     * 获取会议详情新接口
     *
     * @param apiContext 基础header参数, accessToken, orgId, uid
     * @param meetingId  会议id
     * @return
     */
    OpenApiResult<MeetingInviteInfoDTO> detail(ApiContext apiContext, Long meetingId);
}
