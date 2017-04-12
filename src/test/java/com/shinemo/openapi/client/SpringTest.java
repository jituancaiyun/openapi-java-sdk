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

import com.shinemo.openapi.client.service.ContactApiService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by ohun on 2017/3/25.
 *
 * @author ohun@live.cn (夜色)
 */
public final class SpringTest {
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("classpath:open-api-spring.xml");
    }

    @Test
    public void getClient() throws Exception {
        OpenApiClient openApiClient = (OpenApiClient) context.getBean("openApiClient");
        System.out.println(openApiClient.toString());
        System.out.println(openApiClient.getAccessToken());
    }

    @Test
    public void getService() throws Exception {
        ContactApiService contactApiService = (ContactApiService) context.getBean("contactApiService");
        System.out.println(contactApiService.toString());
        System.out.println(contactApiService.listUsers("0", 1));
    }
}
