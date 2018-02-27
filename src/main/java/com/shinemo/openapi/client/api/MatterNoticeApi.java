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
public interface MatterNoticeApi {

    @POST("notification/create")
    Call<OpenApiResult<Map<String, Long>>> create(@HeaderMap Map<String, String> headers, @Body TeamRemindDetailDTO body);

    @POST("notification/cancel")
    Call<OpenApiResult<Void>> cancel(@HeaderMap Map<String, String> headers, @Query("noticeId") long noticeId);

    @POST("notification/delete")
    Call<OpenApiResult<Void>> delete(@HeaderMap Map<String, String> headers, @Query("noticeId") long noticeId);

    @POST("notification/update")
    Call<OpenApiResult<Void>> update(@HeaderMap Map<String, String> headers, @Query("noticeId") long noticeId, @Body TeamRemindDetailDTO body);

    @GET("notification/detail")
    Call<OpenApiResult<TeamRemindInfoDTO>> detail(@HeaderMap Map<String, String> headers, @Query("noticeId") long noticeId);

    @POST("notification/open")
    Call<OpenApiResult<Void>> open(@HeaderMap Map<String, String> headers, @Query("noticeId") long noticeId);

    @POST("notification/close")
    Call<OpenApiResult<Void>> close(@HeaderMap Map<String, String> headers, @Query("noticeId") long noticeId);

}
