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

package com.shinemo.openapi.client.dto.message;


import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.dto.PushMessageDTO;

import java.util.Collection;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
@SuppressWarnings("unchecked")
public abstract class IMessage<T extends IMessage> {
    public static final int FLAG_NOT_SHARE = 0;//不可分享
    public static final int FLAG_CAN_SHARE = 1;//可分享

    public static final int FLAG_ENCRYPT = 1;//加密
    public static final int FLAG_SMS = 2;//必达
    public static final int FLAG_UNREAD = 4;//未读标识

    public static final int FLAG_RECEIVER_LOGIN_ID = 8;//通过登录id发送消息，一般为手机号

    public static final int FLAG_RECEIVER_USER_ID = 16;//开发者所在业务系统用户id


    /**
     * 是否需要加密消息
     */
    private transient int flags;

    /**
     * 发送者ID
     */
    private transient String fromId;

    /**
     * 发送者名称
     */
    private transient String fromName;

    /**
     * 群ID
     */
    private transient Long groupId;

    /**
     * 接收人Uid列表
     */
    private transient Collection<String> receivers;

    /**
     * 加密消息, 推送提醒内容
     */
    private transient String pushTips;

    /**
     * 二级应用ID
     */
    private transient Integer subAppId;

    /**
     * 消息内容
     */
    protected transient String message;


    public IMessage() {
    }

    public IMessage(String message) {
        this.message = message;
    }

    /**
     * 创建文本消息
     *
     * @param content 消息内容
     * @return TextMessage
     */
    public static TextMessage createTextMessage(String content) {
        return new TextMessage(content);
    }

    /**
     * 创建图片消息
     *
     * @param url 图片地址
     * @return ImageMessage
     */
    public static ImageMessage createImageMessage(String url) {
        return new ImageMessage(url);
    }

    /**
     * 创建语音消息
     *
     * @param url 语音消息下载地址
     * @return VoiceMessage
     */
    public static VoiceMessage createVoiceMessage(String url) {
        return new VoiceMessage(url);
    }

    /**
     * 创建应用通知消息
     *
     * @param title 消息标题, 会话列表展示
     * @return AppMessage
     */
    public static AppMessage createAppMessage(String title) {
        return new AppMessage(title).setTitle(title);
    }

    /**
     * 创建OA消息
     * @param title
     * @return
     */
    public static OaMessage createOaMessage(String title) {
        return new OaMessage(title).setTitle(title);
    }

    /**
     * 创建图文消息
     *
     * @param title 消息标题, 会话列表展示
     * @return RichImageMessage
     */
    public static RichImageMessage createTextImageMessage(String title) {
        return new RichImageMessage(title);
    }

    /**
     * 创建文本链接消息
     *
     * @param title 消息标题, 会话列表展示
     * @return RichLinkMessage
     */
    public static RichLinkMessage createTextLinkMessage(String title) {
        return new RichLinkMessage(title);
    }

    /**
     * 创建多图文消息
     *
     * @param title 消息标题, 会话列表展示
     * @return ArticleMessage
     */
    public static ArticleMessage createArticleMessage(String title) {
        return new ArticleMessage(title);
    }

    /**
     * 创建多图文消息
     *
     * @param title 消息标题, 会话列表展示
     * @return SystemMessage
     */
    public static SystemMessage createSystemMessage(String title) {
        return new SystemMessage(title).setTitle(title);
    }


    public PushMessageDTO build() {
        String errorMsg = validate();
        if (errorMsg != null) {
            throw new OpenApiException(errorMsg);
        }

        if (message() == null) {
            throw new OpenApiException("消息标题不能为空");
        }

        if ((flags & FLAG_SMS) != 0 && type() != 1) {
            throw new OpenApiException("只有文本消息支持必达特性");
        }

        if (groupId == null && receivers == null) {
            throw new OpenApiException("groupId和receivers不能同时为空");
        }

        if (groupId != null && receivers != null) {
            throw new OpenApiException("groupId和receivers不能同时存在");
        }

        PushMessageDTO messageDTO = new PushMessageDTO();
        messageDTO.setMessage(message());
        messageDTO.setExtraData(extraData());
        messageDTO.setMsgType(type());
        messageDTO.setFlags(flags);
        messageDTO.setFromId(fromId);
        messageDTO.setFromName(fromName);
        messageDTO.setGroupId(groupId);
        messageDTO.setReceivers(receivers);
        messageDTO.setGroupId(groupId);
        messageDTO.setPushTips(pushTips);
        messageDTO.setSubAppId(subAppId);
        return messageDTO;
    }

    public T setTitle(String title) {
        this.message = title;
        return (T) this;
    }

    /**
     * 设置消息特性, 是否必答消息, 是否需要加密
     *
     * @param flag 是否必答消息, 是否需要加密
     * @return this
     */
    public T addFlag(int flag) {
        this.flags |= flag;
        return (T) this;
    }

    /**
     * 设置消息发送者ID
     *
     * @param fromId 发送者ID
     * @return this
     */
    public T setFromId(String fromId) {
        this.fromId = fromId;
        return (T) this;
    }

    /**
     * 设置消息发送者名称
     *
     * @param fromName 发送者名称
     * @return this
     */
    public T setFromName(String fromName) {
        this.fromName = fromName;
        return (T) this;
    }

    /**
     * 设置接收消息的群ID
     *
     * @param groupId 群ID
     * @return this
     */
    public T setGroupId(long groupId) {
        this.groupId = groupId;
        return (T) this;
    }

    /**
     * 消息接收人列表
     *
     * @param receivers 消息接收人列表
     * @return this
     */
    public T setReceivers(Collection<String> receivers) {
        this.receivers = receivers;
        return (T) this;
    }

    public T setLoginIdReceivers(Collection<String> receivers) {
        this.receivers = receivers;
        this.flags = this.flags | FLAG_RECEIVER_LOGIN_ID;
        return (T) this;
    }

    public T setUserIdReceivers(Collection<String> receivers) {
        this.receivers = receivers;
        this.flags = this.flags | FLAG_RECEIVER_USER_ID;
        return (T) this;
    }

    /**
     * 设置群id
     *
     * @param groupId 消息接收人列表
     * @return this
     */
    public T setGroupId(Long groupId) {
        this.groupId = groupId;
        return (T) this;
    }

    /**
     * 加密消息, 推送提醒内容
     *
     * @param pushTips 可选字段
     * @return this
     */
    public T setPushTips(String pushTips) {
        this.pushTips = pushTips;
        return (T) this;
    }


    public T setSubAppId(int subAppId) {
        this.subAppId = subAppId;
        return (T) this;
    }

    protected String message() {
        return message;
    }

    protected abstract byte type();

    public abstract String validate();

    protected String extraData() {
        return Jsons.toJson(this);
    }
}
