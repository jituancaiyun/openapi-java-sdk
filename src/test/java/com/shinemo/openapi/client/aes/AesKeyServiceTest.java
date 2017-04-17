package com.shinemo.openapi.client.aes;

import com.google.gson.Gson;
import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.aes.db.MysqlAesKeyDao;
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.service.AuthApiService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * Created by yuanjian on 4/14/17.
 */
public class AesKeyServiceTest {

    private AesKeyService aesKeyService;

    @Before
    public void setUp() throws Exception {

        OpenApiClient apiClient = Apis.createClient();
        AuthApiService authApiService = apiClient.createApiService(AuthApiService.class);
        MysqlAesKeyDao aesKeyDao = new MysqlAesKeyDao();
        aesKeyDao.setDataSource(Apis.createDataSource());

        DefaultAesKeyService defaultAesKeyService = new DefaultAesKeyService();
        defaultAesKeyService.setAesKeyDao(aesKeyDao);
        defaultAesKeyService.setOpenApiClient(apiClient);
        defaultAesKeyService.setAuthApiService(authApiService);
        defaultAesKeyService.init();

        aesKeyService = defaultAesKeyService;
    }

    @Test
    public void testByClient() throws Exception {
        OpenApiResult<List<AesKeyEntity>> result = aesKeyService.getAesKeyByClient("1", "1", "token", 123123, "");
        System.out.println(new Gson().toJson(result));
    }

    @Test
    public void testBySDK() throws Exception {
        AesKey aesKey = aesKeyService.getAesKeyBySDK("123923741893");
        System.out.println(aesKey);
    }

}
