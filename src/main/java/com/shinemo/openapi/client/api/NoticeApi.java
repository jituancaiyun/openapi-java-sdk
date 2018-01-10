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
import com.shinemo.openapi.client.dto.notice.NoticeDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * @author yuanjian
 * @date 2017/3/30
 */
public interface NoticeApi {

    @POST("notice/publish")
    Call<OpenApiResult> publish(@HeaderMap Map<String, String> headers, @Body NoticeDTO body);

    @POST("notice/delete")
    Call<OpenApiResult> delete(@HeaderMap Map<String, String> headers, @Query("noticeId") int noticeId);

    @GET("notice/list")
    Call<OpenApiResult<List<NoticeDTO>>> list(@HeaderMap Map<String, String> headers, @Query("startTime") long startTime);

}
