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

import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.common.OpenApiUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import static com.shinemo.openapi.client.callback.CallbackEventType.OrgSubscribe;
import static com.shinemo.openapi.client.common.Const.LOG;
import static com.shinemo.openapi.client.common.Const.UTF_8;
import static com.shinemo.openapi.client.common.OpenApiUtils.validateCallbackSignature;

/**
 * Created by ohun on 2017/4/1.
 *
 * @author ohun@live.cn (夜色)
 */
public abstract class CallbackEventReceiver {

    @Resource
    private OpenApiClient openApiClient;

    protected abstract int on(CallbackEvent event);

    public final void receiver(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (openApiClient == null) {
            throw new OpenApiException("please init OpenApiClient and set to this bean");
        }

        String eventData = getEventData(request);
        if (eventData == null || eventData.isEmpty()) {
            sendResult(response, 400, "event data is empty");
            return;
        }

        CallbackEventBody event = Jsons.fromJson(eventData, CallbackEventBody.class);
        if (event == null || event.getEventType() == null || event.getEncryptData() == null) {
            sendResult(response, 400, "event data is invalid");
            return;
        }

        String appSecret = openApiClient.config().getAppSecret();
        String appToken = openApiClient.config().getAppToken();
        String encryptData = event.getEncryptData();
        String signature = event.getSignature();
        String nonce = event.getNonce();
        long timestamp = event.getTimestamp();

        if (!validateCallbackSignature(signature, appToken, nonce, timestamp, encryptData)) {
            sendResult(response, 400, "validate signature failure");
            return;
        }

        String eventBody = OpenApiUtils.decryptCallbackEvent(appSecret, encryptData);
        if (eventBody == null || eventBody.isEmpty()) {
            sendResult(response, 400, "event data decrypt failure");
            return;
        }

        try {
            int ret = onEvent(event.getEventType(), eventBody);
            sendResult(response, ret, "success");
        } catch (Exception e) {
            LOG.error("CallbackEventReceiver.onEvent error, event={}", event, e);
            sendResult(response, 500, "onEvent error, errorMsg=" + e.getMessage());
        }
    }

    protected abstract int onEvent(String eventType, String eventBody) throws Exception;

    protected <T extends CallbackEvent> T parseEvent(String eventJson, Class<T> eventClass) {
        return openApiClient.config().getGson().fromJson(eventJson, eventClass);
    }

    @SuppressWarnings("unchecked")
    protected <T extends CallbackEvent> T parseEvent(String eventType, String eventBody) {
        if (OrgSubscribe.type.equals(eventType)) {
            return (T) parseEvent(eventBody, OrgSubscribeEvent.class);
        }
        throw new OpenApiException("sdk unsupported event");
    }

    private void sendResult(HttpServletResponse response, int status, String message) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        OpenApiResult<Void> result = new OpenApiResult<Void>();
        result.setStatus(status);
        result.setMessage(message);

        PrintWriter writer = response.getWriter();
        openApiClient.config().getGson().toJson(result, writer);
        writer.close();
    }

    private String getEventData(HttpServletRequest request) throws IOException {
        String contentType = request.getContentType();
        if ("application/x-www-form-urlencoded".equalsIgnoreCase(contentType)) {
            return request.getParameter("event_data");
        }

        int contentLength = request.getContentLength();
        if (contentLength <= 0) contentLength = 1024;
        InputStream in = null;

        try {
            in = request.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream(contentLength);
            byte[] buffer = new byte[contentLength];
            int offset;
            while ((offset = in.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            return new String(out.toByteArray(), UTF_8);
        } finally {
            OpenApiUtils.silentClose(in);
        }
    }

    public void setOpenApiClient(OpenApiClient openApiClient) {
        this.openApiClient = openApiClient;
    }
}
