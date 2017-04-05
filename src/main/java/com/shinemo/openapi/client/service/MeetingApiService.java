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
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MeetingIdDTO;
import com.shinemo.openapi.client.dto.MeetingInviteDTO;

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
     * @param orgId      要访问的企业ID
     * @param meetingDTO 会议实体
     * @return MeetingIdDTO 会议ID
     */
    OpenApiResult<MeetingIdDTO> createMeeting(long orgId, MeetingInviteDTO meetingDTO);

    /**
     * 取消会议邀请
     *
     * @param orgId      要访问的企业ID
     * @param meetingDTO 会议实体
     * @return result code
     */
    OpenApiResult<Long> cancelMeeting(long orgId, MeetingInviteDTO meetingDTO);


    /**
     * 删除会议邀请
     *
     * @param orgId      要访问的企业ID
     * @param meetingDTO 会议实体
     * @return result code
     */
    OpenApiResult<Long> deleteMeeting(long orgId, MeetingInviteDTO meetingDTO);

    /**
     * 修改会议邀请
     *
     * @param orgId      要访问的企业ID
     * @param meetingDTO 会议实体
     * @return result code
     */
    OpenApiResult<Long> updateMeeting(long orgId, MeetingInviteDTO meetingDTO);

    /**
     * 修改会议邀请
     *
     * @param orgId 要访问的企业ID
     * @return result code
     */
    OpenApiResult<Long> getMeeting(long orgId);
}
