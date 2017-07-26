/*
 * (C) Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.shinemo.openapi.client.internal;

import com.google.gson.stream.MalformedJsonException;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.OpenApiConfiguration;
import com.shinemo.openapi.client.api.BaseApi;
import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.common.OpenApiUtils;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import com.shinemo.openapi.client.jssdk.JsapiSignature;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import static com.shinemo.openapi.client.common.Const.LOG;

/**
 * Created by ohun on 2017/3/22.
 *
 * @author ohun@live.cn (夜色)
 */
/*package*/ final class DefaultOpenApiClient implements OpenApiClient {

    private OpenApiConfiguration conf;

    private volatile AccessTokenDTO accessToken;

    private BaseApi baseApi;

    private Retrofit retrofit;

    private ApiServiceProxyFactory apiServiceProxyFactory;

    public DefaultOpenApiClient(OpenApiConfiguration conf) {
        this.conf = conf;
    }

    public void init() {

        if (conf.getBaseUrl() == null) {
            throw new OpenApiException("baseUrl can not be null.");
        }

        if (conf.getAppId() <= 0) {
            throw new OpenApiException("appId can not be null.");
        }

        if (conf.getAppSecret() == null) {
            throw new OpenApiException("appSecret can not be null.");
        }

        if (conf.getMaxRetry() > 3) {
            conf.setMaxRetry(3);
        }

        apiServiceProxyFactory = new ApiServiceProxyFactory(this);

        if (conf.getGson() == null) {
            conf.setGson(Jsons.gson());
        }

        if (conf.getOkHttpClient() == null) {
            conf.setOkHttpClient(
                    new OkHttpClient
                            .Builder()
                            .connectTimeout(conf.getConnectTimeoutMillis(), TimeUnit.MILLISECONDS)
                            .readTimeout(conf.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                            .writeTimeout(conf.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                            .build()
            );
        }

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(conf.getGson()))
                .client(conf.getOkHttpClient())
                .baseUrl(conf.getBaseUrl())
                .build();


        baseApi = retrofit.create(BaseApi.class);

    }


    @Override
    public <T> T createApiService(Class<T> ipServiceClass) {
        return apiServiceProxyFactory.createApiServiceProxy(ipServiceClass);
    }

    @Override
    public OpenApiResult<AccessTokenDTO> getAccessToken() {
        return checkAccessToken();
    }

    @Override
    public JsapiSignature getJsapiSignature(String url) {
        OpenApiResult<AccessTokenDTO> result = getAccessToken();
        if (result.isSuccess()) {
            String ticket = result.getData().getJsapiTicket();
            String none = OpenApiUtils.createNonce();
            long timestamp = OpenApiUtils.createTimestamp();
            String signature = OpenApiUtils.genJsapiSignature(ticket, none, timestamp, url);
            return new JsapiSignature(signature, timestamp, none);
        }
        return null;
    }

    @Override
    public OpenApiConfiguration config() {
        return conf;
    }

    public <T> T createApi(Class<T> apiClass) {
        return retrofit.create(apiClass);
    }

    @SuppressWarnings("unchecked")
    public <T> OpenApiResult<T> callApi(ApiCallable<T> apiCallable) {
        OpenApiResult<AccessTokenDTO> result = checkAccessToken();
        if (result.isSuccess()) {
            return callWithLog(apiCallable.call(accessToken.getAccessToken()), 0);
        }
        return (OpenApiResult<T>) result;
    }

    private OpenApiResult<AccessTokenDTO> checkAccessToken() {
        if (accessToken == null) {//第一次, 同步获取
            return syncRefreshAccessToken();
        }

        long timeout = accessToken.getExpireTime() - System.currentTimeMillis();

        if (timeout > 60 * 1000) {//超时时间大于1分钟
            return OpenApiResult.success(accessToken);
        } else {//超时时间少于1分钟
            if (timeout < 1000) {//超时时间少于1秒, 同步刷新
                return syncRefreshAccessToken();
            } else {
                asyncRefreshAccessToken();//超时时间少于1分钟大于1秒钟, 异步刷新
                return OpenApiResult.success(accessToken);
            }
        }
    }

    private void asyncRefreshAccessToken() {
        Call<OpenApiResult<AccessTokenDTO>> call = baseApi.getAccessToken(conf.getAppId(), conf.getAppSecret(), 0);
        call.enqueue(new Callback<OpenApiResult<AccessTokenDTO>>() {
            @Override
            public void onResponse(Call<OpenApiResult<AccessTokenDTO>> call, Response<OpenApiResult<AccessTokenDTO>> response) {
                if (response.isSuccessful()) {
                    OpenApiResult<AccessTokenDTO> result = response.body();
                    if (result.isSuccess()) {
                        accessToken = result.getData();
                    }
                } else {
                    LOG.error("getAccessToken failure, response={}", response);
                }
            }

            @Override
            public void onFailure(Call<OpenApiResult<AccessTokenDTO>> call, Throwable t) {
                LOG.error("getAccessToken failure", t);
            }
        });
    }

    private OpenApiResult<AccessTokenDTO> syncRefreshAccessToken() {
        OpenApiResult<AccessTokenDTO> result = callWithLog(baseApi.getAccessToken(conf.getAppId(), conf.getAppSecret(), 0), Integer.MAX_VALUE);
        if (result.isSuccess()) {
            this.accessToken = result.getData();
        }
        return result;
    }

    private <T> OpenApiResult<T> callWithLog(Call<OpenApiResult<T>> call, int retryNum) {
        long start = System.nanoTime();
        OpenApiResult<T> result = OpenApiResult.failure();
        try {
            return result = callWithRetry(call, retryNum);
        } finally {
            if (result.isSuccess()) {
                LOG.info("[{}] call open api {} success. result={}"
                        , TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)
                        , call.request()
                        , result
                );
            }
        }
    }

    private <T> OpenApiResult<T> callWithRetry(Call<OpenApiResult<T>> call, int retryNum) {
        try {
            Response<OpenApiResult<T>> response = call.execute();
            if (response.isSuccessful()) {
                OpenApiResult<T> result = response.body();
                if (result.isSuccess()) {
                    return result;
                }
                switch (result.getStatus()) {//accessToken过期, 要同步刷新下accessToken再重试
                    case 4001://accessToken解码错误, 请重新获取
                    case 4002://accessToken不合法, 请重新获取
                    case 4003://accessToken过期, 请重新获取
                    case 4004://accessToken校验不通过, 请重新获取
                        if (syncRefreshAccessToken().isSuccess()) {
                            if (retryNum < conf.getMaxRetry() + 1) {//由token失效引起的错误可以多重试一次
                                return callWithRetry(call.clone(), retryNum + 1);
                            }
                        }
                }
                return result;
            }

            LOG.warn("call open api failure, api={}, body={}", response, response.body());
            return OpenApiResult.failure(response.code(), response.message());
        } catch (SocketTimeoutException e) {
            LOG.error("call open api timeout exception, request={}", call.request(), e);
            return OpenApiResult.failure(408, "请求超时");
        } catch (MalformedJsonException e) {
            LOG.error("call open api parse result exception, request={}", call.request(), e);
            return OpenApiResult.failure(400, "json解析失败");
        } catch (IOException e) {
            LOG.error("call open api exception, request={}", call.request(), e);
            if (retryNum < conf.getMaxRetry()) {
                if (checkAccessToken().isSuccess()) {//重试前, 检查下accessToken
                    LOG.warn("call open api fail, retryNum={}, request={}", retryNum + 1, call.request());
                    return callWithRetry(call.clone(), retryNum + 1);
                }
            }
        } catch (Exception e) {
            LOG.error("call open api exception, request={}", call.request(), e);
        }
        return OpenApiResult.failure();
    }

    public void test(String call, Integer retryNum) {
        System.out.println("test");
    }
}
