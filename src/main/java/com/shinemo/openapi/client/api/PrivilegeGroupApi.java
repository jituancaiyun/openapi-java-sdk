package com.shinemo.openapi.client.api;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.PrivilegeGroupDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.Map;

/**
 * Created by yuanjian on 6/13/17.
 */
public interface PrivilegeGroupApi {

    /**
     * 创建群组
     * @param headers
     * @param body
     * @return
     */
    @POST("privilegeGroup/create")
    Call<OpenApiResult<Map<String, Long>>> create(@HeaderMap Map<String, String> headers, @Body PrivilegeGroupDTO body);

    /**
     * 删除群组
     * @param headers
     * @param groupId
     * @return
     */
    @POST("privilegeGroup/delete")
    Call<OpenApiResult<Long>> delete(@HeaderMap Map<String, String> headers, @Query("groupId") Long groupId);

}
