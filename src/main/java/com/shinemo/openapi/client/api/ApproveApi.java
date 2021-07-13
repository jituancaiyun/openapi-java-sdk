package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.approve.ApprovePageDTO;
import com.shinemo.openapi.client.dto.approve.ApproveTemplateDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

import java.util.Map;

/**
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public interface ApproveApi {

    @GET("approve/getTemplateIds")
    Call<OpenApiResult<ApproveTemplateDTO>> getTemplateIds(@HeaderMap Map<String, String> headers, @Query("businessType") int businessType);

    @GET("approve/query")
    Call<OpenApiResult<Map<String, Object>>> query(@HeaderMap Map<String, String> headers,
                                              @Query("templateIds") String templateIds,
                                              @Query("status") int status,
                                              @Query("beginTime") long beginTime,
                                              @Query("endTime") long endTime,
                                              @Query("pageNum") int pageId,
                                              @Query("pageSize") int pageCount);

}
