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

import com.shinemo.openapi.client.common.*;
import retrofit2.Call;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
/*package*/  final class ApiServiceProxyFactory implements InvocationHandler {

    private final DefaultOpenApiClient client;

    /**
     * key=ApiServiceClass
     * <p>
     * value=ApiProxyBean
     */
    private final Map<Class<?>, ApiProxyBean> apiProxyMap = new HashMap<Class<?>, ApiProxyBean>();

    public ApiServiceProxyFactory(DefaultOpenApiClient client) {
        this.client = client;
    }

    public <T> T createApiServiceProxy(Class<T> apiServiceInterface) {
        return bindApi(apiServiceInterface).createProxy(apiServiceInterface);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(Class<T> apiServiceInterface) {
        return (T) Proxy.newProxyInstance(apiServiceInterface.getClassLoader(), new Class[]{apiServiceInterface}, this);
    }

    /**
     * 把ApiService 和 Api 之间做个映射关系
     *
     * @param apiServiceInterface ApiService
     * @return ApiServiceProxyFactory
     */
    public ApiServiceProxyFactory bindApi(Class<?> apiServiceInterface) {
        if (!apiProxyMap.containsKey(apiServiceInterface)) {

            Api api = apiServiceInterface.getAnnotation(Api.class);
            if (api == null) {
                throw new OpenApiException("bind api to service [" + apiServiceInterface.getName() + "] failure, no binder found.");
            }

            Object apiObj = client.createApi(api.value());
            apiProxyMap.put(apiServiceInterface, new ApiProxyBean(apiObj));
        }
        return this;
    }

    @Override
    public Object invoke(Object apiProxy, Method apiServiceMethod, final Object[] args) throws Throwable {

        ApiProxyBean apiProxyBean = apiProxyMap.get(apiServiceMethod.getDeclaringClass());
        if (apiProxyBean == null) {
            // If the method is a method from Object then defer to normal invocation.
            if (apiServiceMethod.getDeclaringClass() == Object.class) {
                return apiServiceMethod.invoke(this, args);
            }
            throw new OpenApiException("api [" + apiServiceMethod.getName() + "] no implement!");
        }

        Method apiMethod = apiProxyBean.mapping(apiServiceMethod);
        if (apiMethod == null) {
            throw new OpenApiException("api [" + apiServiceMethod.getName() + "] no implement!");
        }

        return invokeApi(apiProxyBean.apiObj, apiMethod, args);
    }

    @SuppressWarnings("unchecked")
    private Object invokeApi(final Object apiObj, final Method apiMethod, final Object[] args) {
        return client.callApi(new ApiCallable<Object>() {
            @Override
            public Call<OpenApiResult<Object>> call(String accessToken) {
                Object[] args_1 = getArgs(args, accessToken);
                try {
                    return (Call<OpenApiResult<Object>>) apiMethod.invoke(apiObj, args_1);
                } catch (Exception e) {
                    throw new OpenApiException(e);
                }
            }
        });
    }


    private Object[] getArgs(Object[] args, String accessToken) {
        ApiContext apiContext;
        Object[] args_1;

        if (args[0] instanceof ApiContext) {
            apiContext = ((ApiContext) args[0]);
            args_1 = args;
        } else {
            apiContext = new ApiContext();
            args_1 = new Object[args.length + 1];
            args_1[0] = apiContext;
            System.arraycopy(args, 0, args_1, 1, args.length);
        }

        apiContext.setAccessToken(accessToken);
        apiContext.putHeader(Const.USER_AGENT_HEADER_NAME, Const.USER_AGENT_HEADER_VALUE);
        return args_1;
    }

    private static class ApiProxyBean {
        Object apiObj;

        Map<String, Method> methods = new HashMap<String, Method>();

        public ApiProxyBean(Object apiObj) {
            this.apiObj = apiObj;
            for (Method method : apiObj.getClass().getInterfaces()[0].getMethods()) {
                methods.put(method.getName(), method);
            }
        }

        public Method mapping(Method method) {
            return methods.get(method.getName());
        }
    }
}
