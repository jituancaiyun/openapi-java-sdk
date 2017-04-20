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

package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.aes.AesKey;
import com.shinemo.openapi.client.aes.AesKeyService;
import com.shinemo.openapi.client.common.*;
import com.shinemo.openapi.client.dto.PushMessageDTO;
import com.shinemo.openapi.client.dto.message.IMessage;

import java.util.List;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class SecurityMessageApiService implements MessageApiService {

    private MessageApiService proxy;

    private OpenApiClient openApiClient;

    private AesKeyService aesKeyService;

    public void init() {
        proxy = openApiClient.createApiService(MessageApiService.class);
    }

    @Override
    public OpenApiResult<List<String>> sendPushMessage(ApiContext apiContext, PushMessageDTO messageDTO) {
        if (messageDTO == null) {
            return OpenApiResult.failure("消息不能为空");
        }

        if (messageDTO.getMsgType() <= 0) {
            return OpenApiResult.failure("消息类型错误");
        }

        if (messageDTO.getMessage() == null) {
            return OpenApiResult.failure("消息标题不能为空");
        }

        if (messageDTO.getExtraData() != null) {
            if (!(messageDTO.getExtraData() instanceof IMessage)) {
                return OpenApiResult.failure("消息格式错误");
            }
            IMessage<?> message = (IMessage<?>) messageDTO.getExtraData();
            String errorMsg = message.validate();
            if (errorMsg != null) {
                return OpenApiResult.failure(errorMsg);
            }
            messageDTO.setExtraData(openApiClient.config().getGson().toJson(message));
        }

        //处理加密消息
        if ((messageDTO.getFlags() & IMessage.FLAG_ENCRYPT) != 0) {
            if (aesKeyService == null) {
                throw new OpenApiException("请初始化AesKeyManager");
            }

            AesKey aesKey = aesKeyService.getAesKeyBySDK(apiContext.getOrgId());

            if (aesKey == null || aesKey.getId() == null || aesKey.getKey() == null) {
                return OpenApiResult.failure("消息加密失败, 无法获取密钥");
            }

            int keyId = aesKey.getId();
            byte[] keyValue = Base64.getUrlDecoder().decode(aesKey.getKey());

            if (messageDTO.getMessage() != null) {
                byte[] encryptMessage = AESUtils.encrypt(messageDTO.getMessage().getBytes(Const.UTF_8), keyValue);
                messageDTO.setMessage(new String(encryptMessage, Const.ISO_8859_1));
            }

            if (messageDTO.getExtraData() != null) {
                byte[] encryptExtraData = AESUtils.encrypt(messageDTO.getExtraData().toString().getBytes(Const.UTF_8), keyValue);
                messageDTO.setExtraData(new String(encryptExtraData, Const.ISO_8859_1));
            }

            messageDTO.setKeyId(keyId);
        }

        return proxy.sendPushMessage(apiContext, messageDTO);
    }

    public void setOpenApiClient(OpenApiClient openApiClient) {
        this.openApiClient = openApiClient;
    }

    public void setAesKeyService(AesKeyService aesKeyService) {
        this.aesKeyService = aesKeyService;
    }
}
