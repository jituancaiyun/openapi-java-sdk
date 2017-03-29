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

package com.shinemo.openapi.client;

import com.shinemo.openapi.client.spring.OpenApiClientFactoryBean;
import com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public final class Apis {

    public static OpenApiConfiguration createConfig() {
        OpenApiConfiguration configuration = new OpenApiConfiguration();
        configuration.setBaseUrl("http://10.0.10.49:8081/openapi/");
        configuration.setAppId("94181123");
        configuration.setAppSecret("6fe73d451cd37f8a");
        configuration.setConnectTimeoutMillis(1000);
        return configuration;
    }

    public static OpenApiClient createClient() throws Exception {
        OpenApiClientFactoryBean factoryBean = new OpenApiClientFactoryBean();
        factoryBean.setConfiguration(createConfig());
        return factoryBean.getObject();
    }

    public static <T> T createApiService(Class<T> apiClass) throws Exception {
        OpenApiServiceFactoryBean<T> factoryBean = new OpenApiServiceFactoryBean<T>();
        factoryBean.setClient(createClient());
        factoryBean.setInterfaceName(apiClass);
        return factoryBean.getObject();
    }
}
