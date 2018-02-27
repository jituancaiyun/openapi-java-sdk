package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.OpenApiConfiguration;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by ohun on 2017/4/16.
 *
 * @author ohun@live.cn (夜色)
 */
public class AuthApiServiceTest {

    private AuthApiService authApiService;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        authApiService = Apis.createApiService(AuthApiService.class);
    }

    @Test
    public void login() throws Exception {
        //String token = "MTAxMDEwMDEyMTI5NDg5fDQ0ZTk0ODE1YWIzZTM1ZTViMmI0NGRlMWFkMzlmNjFifDE0OTMzNzA3ODEwMDA=";
//        String token = "eyJhcHBJZCI6NDQ5NzE4NjEsIm9yZ0lkIjo1NzE3MTU1NDI1MCwic2NvcGVJZCI6NSwic2lnbmF0dXJlIjoiNzY1NjEzZjc0ZDkxODY5YzRjMjYwMTk2ODg5OWE3NDgiLCJzaXRlSWQiOjEsInRpbWVzdGFtcCI6MTUwMTY1NzYwNDE2NSwidWlkIjoiMTA2MTc2In0=";//token ub
        String token = "eyJhcHBJZCI6ODExMjU5NzUsIm9yZ0lkIjo4NTE2MSwic2NvcGVJZCI6Mzc1LCJzaWduYXR1cmUiOiI5YmY4MzBiYzVmMjIxYWE2M2FhMWRjNDcxZmQyYzZiZSIsInNpdGVJZCI6MSwidGltZXN0YW1wIjoxNTE5NjM1MzcyNzY4LCJ1aWQiOiIxMDEwMTAwMTIxMjk0ODkifQ==";
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