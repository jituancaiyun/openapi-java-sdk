package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.api.WorkTraceApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.trace.WorkTracePageDTO;

/**
 * 轨迹
 *
 * @author yuanjian
 * @date 2/1/18
 * @email liuyj@shinemo.com
 */
@Api(WorkTraceApi.class)
public interface WorkTraceApiService {

    /**
     * 根据企业id和时间段查询用户轨迹
     *
     * @param context   http头信息，包括accessToken、orgSecret、uid等
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param pageIndex 分页索引
     * @param pageSize  每页显示数量
     * @return
     */
    OpenApiResult<WorkTracePageDTO> trackList(ApiContext context,
                                              long startTime,
                                              long endTime,
                                              int pageIndex,
                                              int pageSize);

    /**
     * 根据用户id查询用户轨迹信息
     *
     * @param context   http头信息，包括accessToken、orgSecret、uid等
     * @param mobile    用户id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param pageIndex 分页索引
     * @param pageSize  每页显示数量
     * @return
     */
    OpenApiResult<WorkTracePageDTO> queryByMobile(ApiContext context,
                                                  String mobile,
                                                  long startTime,
                                                  long endTime,
                                                  int pageIndex,
                                                  int pageSize);

    /**
     * 根据用户id查询用户正在进行的轨迹
     *
     * @param context http头信息，包括accessToken、orgSecret、uid等
     * @param mobile  用户id
     * @return
     */
    OpenApiResult<WorkTracePageDTO> queryIngByMobile(ApiContext context, String mobile);

}
