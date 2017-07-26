package com.shinemo.openapi.client.service;

import com.google.gson.Gson;
import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiConfiguration;
import com.shinemo.openapi.client.api.BaseApi;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by ohun on 2017/4/16.
 *
 * @author ohun@live.cn (夜色)
 */
public class BaseApiServiceTest {

    private BaseApiService apiService;

    @Before
    public void setUp() throws Exception {
        apiService = Apis.createApiService(BaseApiService.class);
    }

    @Test
    public void token() throws Exception {
        OpenApiConfiguration conf = new OpenApiConfiguration();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(new OkHttpClient
                        .Builder()
                        .connectTimeout(conf.getConnectTimeoutMillis(), TimeUnit.MILLISECONDS)
                        .readTimeout(conf.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                        .writeTimeout(conf.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                        .build())
                .baseUrl("http://10.0.10.49:8081/platform/")
                .build();


        BaseApi baseApi = retrofit.create(BaseApi.class);
        OpenApiResult<AccessTokenDTO> result = callWithLog(baseApi.getAccessToken(12599993, "1f1ea62b71564340869b54e2f3036e55", 0), Integer.MAX_VALUE);
        System.out.println(result);
    }

    private <T> OpenApiResult<T> callWithLog(Call<OpenApiResult<T>> call, int retryNum) throws Exception {
        Class cls = Class.forName("com.shinemo.openapi.client.internal.DefaultOpenApiClient");
        Constructor<?> csr = cls.getConstructor(OpenApiConfiguration.class);  //调用有参构造
        csr.setAccessible(true);
        Object obj = csr.newInstance(new OpenApiConfiguration());
        Method mth = cls.getDeclaredMethod("callWithLog", Call.class, int.class);
        mth.setAccessible(true);
        return (OpenApiResult<T>) mth.invoke(obj, call, retryNum);
    }

}