package com.shinemo.openapi.client;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
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

}