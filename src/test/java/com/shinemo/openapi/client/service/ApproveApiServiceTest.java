package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.Constants;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.approve.ApprovePageDTO;
import com.shinemo.openapi.client.dto.approve.ApproveTemplateDTO;
import org.junit.Before;
import org.junit.Test;

public class ApproveApiServiceTest {

    private ApproveApiService approveApiService;
    private String orgSecret = Constants.OrgSecret.ONLINE_SECRET.orgSecret;
    private String uid = "101010011894152";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(3);
        context = ApiContext.ctx(orgSecret, uid, name);
        approveApiService = Apis.createApiService(ApproveApiService.class);
    }

    @Test
    public void getTemplateIds() {
        OpenApiResult<ApproveTemplateDTO> templateIds = approveApiService.getTemplateIds(context, 0);
        System.out.println(templateIds);
    }

    @Test
    public void query() {
        OpenApiResult<ApprovePageDTO> query = approveApiService.query(context, "1,2,3,4,5,6,7", 1, 1551038146730L, 1553038146730L, 1, 100);
        System.out.println(query);
    }
}