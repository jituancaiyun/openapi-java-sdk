package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.ContactUserDTO;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yuanjian on 5/25/17.
 */
public class UserTest {
    private ContactApiService contactApiService;
    private OpenApiClient client;
    private String orgId = "85161";//"84057";
    private String uid = "101010011894152";//"101010012129489";
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        contactApiService = client.createApiService(ContactApiService.class);
    }

    @Test
    public void detail() {
        OpenApiResult<ContactUserDTO> result = contactApiService.detail(context, 101010012669961L, 10);
        System.out.println(result);
        System.out.println(result.getData());
    }
}
