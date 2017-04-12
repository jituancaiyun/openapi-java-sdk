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

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.PushMessageDTO;
import com.shinemo.openapi.client.dto.message.IMessage;
import com.shinemo.openapi.client.service.SecurityMessageApiService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public class MessageApiTest {
    private SecurityMessageApiService messageApiService;

    @Before
    public void setUp() throws Exception {
        OpenApiClient client = Apis.createClient();
        messageApiService = new SecurityMessageApiService();
        messageApiService.setOpenApiClient(client);
        messageApiService.init();
    }

    @Test
    public void sendTextMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextMessage("我是一条纯文本消息")
                .setReceivers(Arrays.asList("1", "2"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage("1", messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendAppMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createAppMessage("我是一条应用消息")
                .setContent("我是Content")
                .setTitle("我是Title")
                .setUrl("https://jituancaiyun.com")
                .setReceivers(Arrays.asList("1", "2"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage("1", messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendTextImageMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextImageMessage("我是一条图文消息")
                .setContent("我是Content")
                .setTitle("我是Title")
                .setImage("https://jituancaiyun.com")
                .setUrl("https://jituancaiyun.com")
                .setReceivers(Arrays.asList("1", "2"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage("1", messageDTO);
        System.out.println(result);
    }

}
