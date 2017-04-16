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

package com.shinemo.openapi.client.aes;

import com.google.gson.Gson;
import com.shinemo.openapi.client.aes.domain.AesKeyDTO;
import com.shinemo.openapi.client.aes.domain.ResultMsg;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import static com.shinemo.openapi.client.common.Const.LOG;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenAesKeyServlet extends HttpServlet {

    private AesKeyService aesKeyService;

    private Gson gson = new Gson();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        if (applicationContext == null) {
            throw new OpenApiException("can not find spring application context");
        }
        Map beans = applicationContext.getBeansOfType(AesKeyService.class);
        if (beans == null || beans.isEmpty()) {
            throw new OpenApiException("can not find CallbackEventReceiver form spring application context");
        }
        aesKeyService = (AesKeyService) beans.entrySet().iterator().next();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        String uid = req.getParameter("uid");
        String orgId = req.getParameter("orgId");
        String timestamp = req.getParameter("timestamp");
        String ids = req.getParameter("ids");

        try {
            ResultMsg<Map<String,List<AesKeyDTO>>>  result = aesKeyService.getAesKeyByClient(token, uid, Long.parseLong(timestamp),Long.parseLong(orgId), ids);
            writeResult(resp, result);
        } catch (Exception e) {
            writeResult(resp, ResultMsg.error(500, "服务器内部错误"));
            LOG.error("get aes key error, ids={}, orgId={}, uid={}, token={}, timestamp={}", ids, orgId, uid, token, timestamp);
        }
    }

    private void writeResult(HttpServletResponse response, ResultMsg<?> result) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        gson.toJson(result, writer);
        writer.close();
    }
}
