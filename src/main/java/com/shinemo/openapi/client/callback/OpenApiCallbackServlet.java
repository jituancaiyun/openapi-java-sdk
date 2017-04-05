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

package com.shinemo.openapi.client.callback;

import com.shinemo.openapi.client.common.OpenApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ohun on 2017/4/1.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenApiCallbackServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(OpenApiCallbackServlet.class);

    private CallbackEventReceiver callbackEventReceiver;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        if (applicationContext == null) {
            throw new OpenApiException("can not find spring application context");
        }
        Map beans = applicationContext.getBeansOfType(CallbackEventReceiver.class);
        if (beans == null || beans.isEmpty()) {
            throw new OpenApiException("can not find CallbackEventReceiver form spring application context");
        }
        callbackEventReceiver = (CallbackEventReceiver) beans.entrySet().iterator().next();
        logger.debug("init open api callback servlet success.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        callbackEventReceiver.receiver(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
