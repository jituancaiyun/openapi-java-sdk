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
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public final class Apis {
    private static int env = 1;

    public static OpenApiConfiguration createConfig() {
        OpenApiConfiguration configuration = new OpenApiConfiguration();
        if (env == 0) {
            configuration.setBaseUrl("http://127.0.0.1:8081/openapi/");
            configuration.setAppId(94181123);
            configuration.setAppSecret("6fe73d451cd37f8a");
        } else if (env == 1) {
            configuration.setBaseUrl("http://10.0.10.49:8081/openapi/");
            configuration.setAppId(94181123);
            configuration.setAppSecret("6fe73d451cd37f8a");
        } else if (env == 2) {
            configuration.setBaseUrl("http://10.0.10.49:8081/platform/");
            configuration.setAppId(20328985);
            configuration.setAppSecret("$e'yVi2_7i_wU_k_jjPX$_Op_ya\\AUKL");
        } else if (env == 3) {
            configuration.setBaseUrl("https://openapi.e.uban360.com/platform/");
            configuration.setAppId(27714980);
            configuration.setAppSecret("S14'e*;9Zo_8TU\"U:_rzP8crwP<_hV8D");
        } else {
            configuration.setBaseUrl("https://api.open.jituancaiyun.com/openapi/");
            configuration.setAppId(48906502);
            configuration.setAppSecret("DF2D43CCAC737521");
        }
        configuration.setConnectTimeoutMillis(10000);
        configuration.setMaxRetry(1);
        return configuration;
    }

    public static OpenApiClient createClient() throws Exception {
        OpenApiClientFactoryBean factoryBean = new OpenApiClientFactoryBean();
        factoryBean.setConfiguration(createConfig());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    public static <T> T createApiService(Class<T> apiClass) throws Exception {
        OpenApiServiceFactoryBean<T> factoryBean = new OpenApiServiceFactoryBean<T>();
        factoryBean.setApiServiceFactory(createClient());
        factoryBean.setInterfaceName(apiClass);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }


    public static DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.0.10.41:3306/shinemo_openapi");
        dataSource.setUsername("root");
        dataSource.setPassword("shinemo123");
        return dataSource;
    }
}
