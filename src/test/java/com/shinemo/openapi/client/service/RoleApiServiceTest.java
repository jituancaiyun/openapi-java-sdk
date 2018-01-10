package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import org.junit.Before;
import org.junit.Test;

public class RoleApiServiceTest {

    private RoleApiService roleApiService;
    private String orgSecret = "AQAOAQAAAAAAAFlIAQAAAAAA";
    private String uid = "101010011894152";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        context = ApiContext.ctx(orgSecret, uid, name);
        roleApiService = Apis.createApiService(RoleApiService.class);
    }

    @Test
    public void queryById() throws Exception {
        System.out.println(roleApiService.queryById(context, 0));
    }

    @Test
    public void list() throws Exception {
        System.out.println(roleApiService.list(context));
    }

}