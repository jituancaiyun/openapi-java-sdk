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
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;
import com.shinemo.openapi.client.common.OpenApiResult;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.shinemo.openapi.client.common.Const.LOG;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public class OpenAesKeyServlet extends HttpServlet {

    private final Gson gson = new Gson();

    @Resource
    protected AesKeyService aesKeyService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        String uid = req.getHeader("uid");
        String orgId = req.getHeader("orgId");
        String timestamp = req.getHeader("timestamp");
        String ids = req.getParameter("ids");

        try {
            OpenApiResult<List<AesKeyEntity>> result = aesKeyService.getAesKeyByClient(orgId, uid, token, Long.parseLong(timestamp), ids);
            writeResult(resp, result);
        } catch (Exception e) {
            writeResult(resp, OpenApiResult.failure(500, "服务器内部错误"));
            LOG.error("get aes key error, ids={}, orgId={}, uid={}, token={}, timestamp={}", ids, orgId, uid, token, timestamp);
        }
    }

    private void writeResult(HttpServletResponse response, OpenApiResult<?> result) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        gson.toJson(result, writer);
        writer.close();
    }

    public void setAesKeyService(AesKeyService aesKeyService) {
        this.aesKeyService = aesKeyService;
    }
}
