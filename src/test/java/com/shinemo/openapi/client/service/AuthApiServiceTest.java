package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ohun on 2017/4/16.
 *
 * @author ohun@live.cn (夜色)
 */
public class AuthApiServiceTest {

    private AuthApiService authApiService;

    @Before
    public void setUp() throws Exception {
        authApiService = Apis.createApiService(AuthApiService.class);
    }

    @Test
    public void login() throws Exception {
        String token = "MTczMDMyNjR8N2NmZWY4MTc5ZGY5NTA5MmZjOWRkOGYzMTQwM2M5YzR8MTQ5MzA0NTQyODAwMA==";
        OpenApiResult<UserInfoDTO> result = authApiService.login(token);
        System.out.println(result);
    }

    @Test
    public void checkHttpToken() throws Exception {
        String token = "7b3805d682345d92bebc3b9031a5673f";
        long timestamp = 1492141226083L;
        OpenApiResult<Void> result = authApiService.checkHttpToken(ApiContext.ctx("82329", "563905"), token, timestamp);
        System.out.println(result);
    }
}