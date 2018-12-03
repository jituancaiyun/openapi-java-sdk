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

import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.Base64;
import com.shinemo.openapi.client.spring.OpenApiClientFactoryBean;
import com.shinemo.openapi.client.spring.OpenApiServiceFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public final class Apis {
    public static void setEnv(int env) {
        Apis.env = env;
    }

    private static int env = 3;

    public static OpenApiConfiguration createConfig() {
        OpenApiConfiguration configuration = new OpenApiConfiguration();
        if (env == 0) {
            configuration.setBaseUrl("http://127.0.0.1:8081/platform/api/");
            /*appId为94181123的应用已绑定企业84057*/
            configuration.setAppId(12599993);
            configuration.setAppSecret("1f1ea62b71564340869b54e2f3036e55");
        } else if (env == 1) {
            configuration.setBaseUrl("http://10.0.10.49:8081/platform/api/");
            configuration.setAppId(81125975);
            configuration.setAppSecret("6b63fd58e54b4726402a54dbd5429f56");
        } else if (env == 2) {
            configuration.setBaseUrl("http://10.0.10.49:8081/platform/");
            configuration.setAppId(20328985);
            configuration.setAppSecret("$e'yVi2_7i_wU_k_jjPX$_Op_ya\\AUKL");
        } else if (env == 3) {
            configuration.setBaseUrl("https://openapi.e.uban360.com/platform/api/");
            configuration.setAppId(65060251);
            configuration.setAppSecret("55c9d1cedac11a19bb6e1424b7d7c698");
        } else if (env == 4) {
            configuration.setBaseUrl("http://127.0.0.1:8082/platform/");
            configuration.setAppId(20328985);
            configuration.setAppSecret("$e'yVi2_7i_wU_k_jjPX$_Op_ya\\AUKL");
        } else if (env == 5) {
            configuration.setBaseUrl("https://openapi.e.uban360.com/platform/api/");
            configuration.setAppId(3637976);
            configuration.setAppSecret("2e6bfb5ffb05049b700febbc795a2739");
        }else if (env == 6) {
            configuration.setBaseUrl("https://openapi.e.uban360.com/platform/api/");
            configuration.setAppId(82735395);
            configuration.setAppSecret("ea9126c4f1650421f4e1c83703f2ea49");
        }else if (env == 7) {
            // 达威公车
            configuration.setBaseUrl("https://openapi.e.uban360.com/platform/api/");
            configuration.setAppId(72280195);
            configuration.setAppSecret("991a397d8cc43c6516665af1828360ce");
        } else {
            configuration.setBaseUrl("https://api.open.jituancaiyun.com/openapi/");
            configuration.setAppId(92707367);
            configuration.setAppSecret("e73411429d25257e893b373052130dd2");// 短码通线上
            /*appId为80108056的应用已绑定企业83040*/
            //configuration.setAppId(88734928);
            //configuration.setAppSecret("7a2cca422321cb9945eb39be384afd6f");
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

    public static ApiContext ctx(long orgId) {
        return ApiContext.ctx(Base64.getUrlEncoder().encodeToString(
                ByteBuffer.allocate(10).order(ByteOrder.LITTLE_ENDIAN).putShort((short) 1).putLong(orgId).array()
        ));
    }
}
