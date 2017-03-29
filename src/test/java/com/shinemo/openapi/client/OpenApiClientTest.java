package com.shinemo.openapi.client;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
public class OpenApiClientTest {
    private OpenApiClient client;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
    }

    @Test
    public void getToken() throws Exception {
        OpenApiResult<AccessTokenDTO> result = client.getAccessToken();
        System.out.println(result);
    }

    @org.junit.Test
    public void login() throws Exception {
        String loginToken = "ODQwNjk3fDgwZTg3YzM5YmNiYTc0Mjc1ZTcwNDg1ZjM2NzU1OWVifDE0ODk5Nzk0NzYwMDA=";

        OpenApiResult<UserInfoDTO> result = client.login(loginToken);
        System.out.println(result);
    }

}