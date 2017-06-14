package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by yuanjian on 6/13/17.
 */
public class BlackListServiceTest {
    private BlacklistApiService blacklistApiService;
    private OpenApiClient client;
    private String orgId = "84057";
    private String uid = "101010012129489";
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        blacklistApiService = client.createApiService(BlacklistApiService.class);
    }

}
