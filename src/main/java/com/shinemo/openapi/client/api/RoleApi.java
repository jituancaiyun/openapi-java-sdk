package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.Map;

/**
 * 角色接口
 *
 * @author yuanjian
 * @date 1/10/18
 * @email liuyj@shinemo.com
 */
public interface RoleApi {

    @GET("role/users")
    Call<OpenApiResult> queryById(@HeaderMap Map<String, String> headers, @Query("roleId") int roleId);

    @GET("role/list")
    Call<OpenApiResult> list(@HeaderMap Map<String, String> headers);

}
