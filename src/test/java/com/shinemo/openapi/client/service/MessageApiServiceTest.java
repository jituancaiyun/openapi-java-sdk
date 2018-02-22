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
import com.shinemo.openapi.client.dto.message.EmailMessage;
import com.shinemo.openapi.client.dto.message.IMessage;
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

    private MessageApiService messageApiService;
    private OpenApiClient client;

    //private ApiContext ctx = new ApiContext("96256");
    //private List<String> receivers = Arrays.asList("181705176", "106176", "80864", "105824", "112093240");

    private ApiContext ctx = new ApiContext().setOrgSecret("AQB1AQAAAAAAAFlIAQAAAAAA");
    private List<String> receivers = Arrays.asList("101010012129489"/*, "112093240", "80864", "105824"*/);


    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        client = Apis.createClient();
        messageApiService = client.createApiService(MessageApiService.class);
    }

    @Test
    public void sendAppMessageEasy() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createAppMessage("我是一条应用消息")
                .setContent("我是一条应用消息Content")
                .setTitle("我是一条应用消息Title")
                .setPreTitle("工会")
                .setColor("green")
                .setAppId(client.config().getAppId())//要显示红点的应用ID
                .setOrgId("85161")//要显示红点的应用所属企业
                .setUrlAction("https://jituancaiyun.com")
                .setReceivers(receivers)
                .build();
        System.out.println(messageApiService.sendAppMessage(ctx, messageDTO));
    }

    @Test
    public void sendGroupMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextMessage("我是一条纯文本消息")
                .setGroupId(125680L)
//                .setFromName("应用消息ee")
                .build();
        // 图片消息
        /*PushMessageDTO messageDTO = IMessage
                .createImageMessage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3664202321,2483816645&fm=11&gp=0.jpg")
                .setGroupId(125680L)
                .setHeight(300)
                .setWidth(300)
                .setGif(false)
                .build();*/
        // 邮件消息
        /*PushMessageDTO messageDTO = new EmailMessage("我是一条邮件消息")
                .setSender("106176")
                .setmContent("我是一条邮件消息的内容")
                .setmUrl("https://jituancaiyun.com")
                .setSendTime(System.currentTimeMillis())
                .setGroupId(125680L)
                .build();*/
        // 图文消息
        /*PushMessageDTO messageDTO = IMessage
                .createTextImageMessage("我是一条图文消息")
                .setContent("我是一条图文消息Content")
                .setTitle("我是一条图文消息Title")
                .setImage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3664202321,2483816645&fm=11&gp=0.jpg")
                .setUrl("https://baidu.com")
                .setGroupId(125680L)
                .build();*/
        System.out.println(messageApiService.sendPushMessage(ctx, messageDTO));

    }

    @Test
    public void sendMailMessage() throws Exception {
        PushMessageDTO messageDTO = new EmailMessage("我是一条邮件消息")
                .setSender("106176")
                .setmContent("我是一条邮件消息的内容")
                .setmUrl("https://jituancaiyun.com")
                .setSendTime(System.currentTimeMillis())
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendTextMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createTextMessage("我是一条纯文本消息")
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendImageMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createImageMessage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3664202321,2483816645&fm=11&gp=0.jpg")
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
        System.out.println(result);
    }

    @Test
    public void sendAppMessage() throws Exception {
        PushMessageDTO messageDTO = IMessage
                .createAppMessage("我是一条应用消息")
                .setContent("我是一条应用消息Content")
                .setTitle("我是一条应用消息Title")
                .setPreTitle("工会")
                .setColor("green")
                .setUnreadCount(3)// 未读消息数, 目前是显示红点
                .setAppId(client.config().getAppId())// 要显示红点的应用ID
                .setOrgId(ctx.getOrgId())// 要显示红点的应用所属企业
                .setUrlAction("https://jituancaiyun.com")
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
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
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
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
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
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
                .setReceivers(receivers)
                .build();

        OpenApiResult<List<String>> result = messageApiService.sendPushMessage(ctx, messageDTO);
        System.out.println(result);
    }
}
