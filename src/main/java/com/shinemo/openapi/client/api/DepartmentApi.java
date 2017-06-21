package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanjian on 6/7/17.
 */
public interface DepartmentApi {

    @POST("branch/create")
    Call<OpenApiResult<Map<String, Long>>> create(@HeaderMap Map<String, String> headers, @Body DeptInfoDTO body);

    @POST("branch/delete")
    Call<OpenApiResult<Long>> delete(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @POST("branch/update")
    Call<OpenApiResult<Long>> update(@HeaderMap Map<String, String> headers, @Body DeptInfoDTO deptInfoDTO);

    @GET("branch/detail")
    Call<OpenApiResult<Map<String, DeptInfoDTO>>> detail(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @GET("branch/deptList")
    Call<OpenApiResult<Map<String, List<DeptInfoDTO>>>> deptList(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);
}
