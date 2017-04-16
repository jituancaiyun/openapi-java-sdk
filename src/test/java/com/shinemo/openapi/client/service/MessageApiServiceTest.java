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

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
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
public class MessageApiServiceTest {
    private SecurityMessageApiService messageApiService;

    private OpenApiClient client;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
        messageApiService = new SecurityMessageApiService();
        messageApiService.setOpenApiClient(client);
        messageApiService.init();
    }

    @Test
    public void sendTextMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextMessage("我是一条纯文本消息")
                .setReceivers(Arrays.asList("101010012111025", "101010011746392"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ApiContext.ctx("57171554250"), messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendImageMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createImageMessage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3664202321,2483816645&fm=11&gp=0.jpg")
                .setReceivers(Arrays.asList("101010012111025", "101010011746392"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ApiContext.ctx("57171554250"), messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendAppMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createAppMessage("我是一条应用消息")
                .setContent("我是一条应用消息Content")
                .setTitle("我是一条应用消息Title")
                .setUrlAction(client.config().getAppId(), "https://jituancaiyun.com", "")
                .setReceivers(Arrays.asList("101010012111025", "101010011746392"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ApiContext.ctx("57171554250"), messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendTextImageMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextImageMessage("我是一条图文消息")
                .setContent("我是一条图文消息Content")
                .setTitle("我是一条图文消息Title")
                .setImage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3664202321,2483816645&fm=11&gp=0.jpg")
                .setUrl("https://baidu.com")
                .setReceivers(Arrays.asList("101010012111025", "101010011746392"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ApiContext.ctx("57171554250"), messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendTextLinkMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextLinkMessage("我是一条链接消息")
                .setContent("我是一条链接消息Content")
                .setTitle("我是一条链接消息Title")
                .setImage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3664202321,2483816645&fm=11&gp=0.jpg")
                .setUrl("https://jituancaiyun.com")
                .setReceivers(Arrays.asList("101010012111025", "101010011746392"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ApiContext.ctx("57171554250"), messageDTO);
        System.out.println(result);
    }


    @Test
    public void sendSystemMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createSystemMessage("我是一条系统消息")
                .setContent("我是一条系统消息Content")
                .setTitle("我是一条系统消息Title")
                .setDesc("我是一条系统消息Desc1", "我是一条系统消息Desc2")
                .setAction("https://jituancaiyun.com")
                .setReceivers(Arrays.asList("101010012111025", "101010011746392"))
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ApiContext.ctx("57171554250"), messageDTO);
        System.out.println(result);
    }


}
