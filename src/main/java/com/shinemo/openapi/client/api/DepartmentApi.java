package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanjian on 6/7/17.
 */
public interface DepartmentApi {

    @POST("department/create")
    Call<OpenApiResult<Map<String, Long>>> create(@HeaderMap Map<String, String> headers, @Body DeptInfoDTO body);

    @POST("department/delete")
    Call<OpenApiResult<Void>> delete(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @POST("department/update")
    Call<OpenApiResult<Void>> update(@HeaderMap Map<String, String> headers, @Body DeptInfoDTO deptInfoDTO);

    @GET("department/detail")
    Call<OpenApiResult<Map<String, DeptInfoDTO>>> detail(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @GET("department/deptList")
    Call<OpenApiResult<Map<String, List<DeptInfoDTO>>>> deptList(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @GET("department/userList")
    Call<OpenApiResult<Map<String,List<UserInfoDTO>>>> userList(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

    @GET("department/userListAll")
    Call<OpenApiResult<Map<String,List<UserInfoDTO>>>> userListAll(@HeaderMap Map<String, String> headers, @Query("deptId") Long deptId);

}
