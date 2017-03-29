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

package com.shinemo.openapi.client.spring;

import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.OpenApiException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenApiServiceFactoryBean<T> implements FactoryBean<T>, InitializingBean {

    private OpenApiClient client;

    private Class<T> interfaceClass;

    private T apiService;

    public OpenApiClient getClient() {
        return client;
    }

    public void setClient(OpenApiClient client) {
        this.client = client;
    }

    public Class<T> getInterfaceName() {
        return interfaceClass;
    }

    public void setInterfaceName(Class<T> interfaceName) {
        this.interfaceClass = interfaceName;
    }

    @Override
    public T getObject() throws Exception {
        return apiService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (client == null) {
            throw new OpenApiException("dependency open api client can not be null.");
        }

        if (interfaceClass == null) {
            throw new OpenApiException("open api service interfaceName can not be null.");
        }

        apiService = client.createApiService(getObjectType());
    }
}
