package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.trace.WorkTracePageDTO;
import retrofit2.Call;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.Map;

/**
 * 工作轨迹
 *
 * @author yuanjian
 * date 2/1/18
 * email liuyj@shinemo.com
 */
public interface WorkTraceApi {

    @POST("workTrace/list")
    Call<OpenApiResult<WorkTracePageDTO>> trackList(@HeaderMap Map<String, String> headers,
                                                    @Query("startTime") long startTime,
                                                    @Query("endTime") long endTime,
                                                    @Query("pageIndex") int pageIndex,
                                                    @Query("pageSize") int pageSize);

    @POST("workTrace/queryByMobile")
    Call<OpenApiResult<WorkTracePageDTO>> queryByMobile(@HeaderMap Map<String, String> headers,
                                                        @Query("mobile") String mobile,
                                                        @Query("startTime") long startTime,
                                                        @Query("endTime") long endTime,
                                                        @Query("pageIndex") int pageIndex,
                                                        @Query("pageSize") int pageSize);

    @POST("workTrace/queryIngByMobile")
    Call<OpenApiResult<WorkTracePageDTO>> queryIngByMobile(@HeaderMap Map<String, String> headers, @Query("mobile") String mobile);

}
