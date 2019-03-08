package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.api.ApproveApi;
import com.shinemo.openapi.client.common.Api;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.approve.ApprovePageDTO;
import com.shinemo.openapi.client.dto.approve.OrgTemplateInfos;

/**
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
@Api(ApproveApi.class)
public interface ApproveApiService {

    /**
     * 查询审批类型列表
     *
     * @param businessType 业务类型, 0查询所有
     * @return
     */
    OpenApiResult<OrgTemplateInfos> getTemplateIds(ApiContext context, int businessType);

    /**
     * 分页查询审批列表
     *
     * @param templateIds 审批类型的id多个“,”分隔,（参看审批类型列表接口)
     * @param status      审批状态（0.进行中 1.同意 2.被拒绝 3.撤销 4.回退 5.删除）
     * @param beginTime   搜索开始时间, 单位:毫秒,(搜索的字段为审批发起的时间)
     * @param endTime     搜索结束时间, 单位:毫秒,搜索的字段为审批发起的时间
     * @param pageId      分页索引，从1开始
     * @param pageCount   每页显示数量，默认20，最大500
     * @return
     */
    OpenApiResult<ApprovePageDTO> query(ApiContext context,
                                        String templateIds,
                                        int status,
                                        long beginTime,
                                        long endTime,
                                        int pageId,
                                        int pageCount);

}
