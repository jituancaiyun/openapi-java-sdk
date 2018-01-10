package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.api.RoleApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;

/**
 * 角色
 *
 * @author yuanjian
 * @date 1/10/18
 * @email liuyj@shinemo.com
 */
@Api(RoleApi.class)
public interface RoleApiService {

    /**
     * 根据id查询角色信息
     *
     * @param context  http头信息，包括accessToken、orgSecret、uid等
     * @param noticeId
     * @return
     */
    OpenApiResult queryById(ApiContext context, int noticeId);

    /**
     * 查询角色列表
     *
     * @param context http头信息，包括accessToken、orgSecret、uid等
     * @return
     */
    OpenApiResult list(ApiContext context);

}
