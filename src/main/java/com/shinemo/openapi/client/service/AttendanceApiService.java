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

import com.shinemo.openapi.client.api.AttendanceApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.attendance.ImportSignInfoDTO;
import com.shinemo.openapi.client.dto.attendance.SignInfoDTO;

import java.util.List;

/**
 * Created by ohun on 2017/3/30.
 *
 * @author ohun@live.cn (夜色)
 */
@Api(AttendanceApi.class)
public interface AttendanceApiService {

    /**
     * 新增考勤数据
     *
     * @param context     http头信息，包括accessToken、orgSecret、uid等
     * @param signInfoDTO 考勤数据
     * @return result code
     */
    OpenApiResult<Void> add(ApiContext context, ImportSignInfoDTO signInfoDTO);

    /**
     * 批量新增考勤数据
     *
     * @param context      http头信息，包括accessToken、orgSecret、uid等
     * @param signInfoDTOS 考勤数据
     * @return result code
     */
    OpenApiResult<Void> importBatch(ApiContext context, List<ImportSignInfoDTO> signInfoDTOS);

    /**
     * 查询考勤数据
     *
     * @param context   http头信息，包括accessToken、orgSecret、uid等
     * @param beginTime beginTime
     * @param endTime   endTime
     * @return 考勤结果
     */
    OpenApiResult<List<SignInfoDTO>> query(ApiContext context, String beginTime, String endTime);

}
