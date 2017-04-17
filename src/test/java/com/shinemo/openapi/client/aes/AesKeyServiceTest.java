package com.shinemo.openapi.client.aes;

import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.OpenApiConfiguration;
import com.shinemo.openapi.client.aes.db.AesKeyDao;
import com.shinemo.openapi.client.aes.db.MysqlAesKeyDao;
import com.shinemo.openapi.client.aes.domain.AesKeyDTO;
import com.shinemo.openapi.client.aes.domain.ResultMsg;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import com.shinemo.openapi.client.service.AuthApiService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanjian on 4/14/17.
 */
public class AesKeyServiceTest {
    AesKeyService aesKeyService = new DefaultAesKeyService();
    AesKeyDao aesKeyDao = new MysqlAesKeyDao();
    @Test
    public void testByIds() throws Exception {

        initAesKeyService();

        aesKeyService.init();
        ResultMsg<Map<String,List<AesKeyDTO>>> result = aesKeyService.getAesKeyByClient(",","",123923741893L,123123,"1,2,3,4,5,6,7,8,40,42,43");
        System.out.println(result);
    }

    @Test
    public void testByOrgs() throws Exception {

        initAesKeyService();

        aesKeyService.init();
        ResultMsg<Map<String,List<AesKeyDTO>>> result = aesKeyService.getAesKeyByClient(",","",123923741893L,123125,null);
        System.out.println(result.getData().get("keys"));
    }

    private void initAesKeyService(){
        aesKeyDao.setDataSource(ServiceConfig.configDataSource());
        aesKeyService.setAesKeyDao(aesKeyDao);
        aesKeyService.setAuthApiService(new AuthApiService() {
            @Override
            public OpenApiResult<UserInfoDTO> login(String authToken) {
                return null;
            }

            @Override
            public OpenApiResult<Void> checkHttpToken(String httpToken, long timestamp, String uid, String orgId) {
                return null;
            }
        });
        aesKeyService.setOpenApiClient(new OpenApiClient() {
            @Override
            public OpenApiResult<AccessTokenDTO> getAccessToken() {
                return null;
            }

            @Override
            public OpenApiResult<UserInfoDTO> login(String loginToken) {
                return null;
            }

            @Override
            public OpenApiConfiguration config() {
                return null;
            }

            @Override
            public <T> T createApiService(Class<T> apiServiceInterface) {
                return null;
            }
        });
    }
}
