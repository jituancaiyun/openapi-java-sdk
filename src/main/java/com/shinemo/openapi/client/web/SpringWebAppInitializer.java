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

package com.shinemo.openapi.client.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Map;

/**
 * Created by ohun on 2017/4/19.
 *
 * @author ohun@live.cn (夜色)
 */
public final class SpringWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        if (context == null) return;

        Map openApiAesKeyServlets = context.getBeansOfType(OpenApiAesKeyServlet.class);
        if (openApiAesKeyServlets != null && !openApiAesKeyServlets.isEmpty()) {
            OpenApiAesKeyServlet openApiAesKeyServlet = (OpenApiAesKeyServlet) openApiAesKeyServlets.values().iterator().next();
            if (openApiAesKeyServlet != null) {
                ServletRegistration.Dynamic registration4aesKey = servletContext.addServlet("OpenApiAesKeyServlet", openApiAesKeyServlet);
                registration4aesKey.addMapping("/queryKey");
            }
        }

        Map openApiCallbackServlets = context.getBeansOfType(OpenApiCallbackServlet.class);
        if (openApiCallbackServlets != null && !openApiCallbackServlets.isEmpty()) {
            OpenApiCallbackServlet openApiCallbackServlet = (OpenApiCallbackServlet) openApiCallbackServlets.values().iterator().next();
            if (openApiCallbackServlet != null) {
                ServletRegistration.Dynamic registration4callback = servletContext.addServlet("OpenApiCallbackServlet", openApiCallbackServlet);
                registration4callback.addMapping("/callback");
            }
        }

        System.err.println("===================================================================");
        System.err.println("===================OPEN-API-SERVER START SUCCESS===================");
        System.err.println("===================================================================");
        */
    }
}
