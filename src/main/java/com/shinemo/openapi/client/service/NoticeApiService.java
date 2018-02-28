package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.api.NoticeApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.attendance.SignInfoDTO;
import com.shinemo.openapi.client.dto.notice.NoticeDTO;

import java.util.List;

/**
 * 公告
 *
 * @author yuanjian
 * date 1/8/18
 * email liuyj@shinemo.com
 */
@Api(NoticeApi.class)
public interface NoticeApiService {
    /**
     * 发布公告
     *
     * @param context http头信息，包括accessToken、orgSecret、uid等
     * @param body    公告信息
     * @return result code
     */
    OpenApiResult<Void> publish(ApiContext context, NoticeDTO body);

    /**
     * 删除公告
     *
     * @param context  http头信息，包括accessToken、orgSecret、uid等
     * @param noticeId 公告id
     * @return result code
     */
    OpenApiResult<Void> delete(ApiContext context, int noticeId);

    /**
     * 查询公告
     *
     * @param context   http头信息，包括accessToken、orgSecret、uid等
     * @param startTime 起始时间
     * @return result code
     */
    OpenApiResult<List<SignInfoDTO>> list(ApiContext context, long startTime);
}
