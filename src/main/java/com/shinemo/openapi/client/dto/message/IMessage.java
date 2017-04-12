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
    public static final int FLAG_ENCRYPT = 1;

    /**
     * 是否需要加密消息
     */
    private transient boolean needEncrypt;

    /**
     * 接收人Uid列表
     */
    private transient Collection<String> receivers;

    /**
     * 加密消息, 推送提醒内容
     */
    private transient String pushTips;

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
     * @return
     */
    public static TextMessage createTextMessage(String content) {
        return new TextMessage(content);
    }

    /**
     * 创建图片消息
     *
     * @param url 图片地址
     * @return
     */
    public static ImageMessage createImageMessage(String url) {
        return new ImageMessage(url);
    }

    /**
     * 创建语音消息
     *
     * @param url 语音消息下载地址
     * @return
     */
    public static VoiceMessage createVoiceMessage(String url) {
        return new VoiceMessage(url);
    }

    /**
     * 创建应用通知消息
     *
     * @param title 消息标题, 会话列表展示
     * @return
     */
    public static AppMessage createAppMessage(String title) {
        return new AppMessage(title).setTitle(title);
    }

    /**
     * 创建图文消息
     *
     * @param title 消息标题, 会话列表展示
     * @return
     */
    public static RichImageMessage createTextImageMessage(String title) {
        return new RichImageMessage(title);
    }

    /**
     * 创建文本链接消息
     *
     * @param title 消息标题, 会话列表展示
     * @return
     */
    public static RichLinkMessage createTextLinkMessage(String title) {
        return new RichLinkMessage(title);
    }

    /**
     * 创建多图文消息
     *
     * @param title
     * @return
     */
    public static ArticleMessage createArticleMessage(String title) {
        return new ArticleMessage(title);
    }

    public PushMessageDTO build() {
        PushMessageDTO messageDTO = new PushMessageDTO();
        messageDTO.setMessage(message());
        messageDTO.setExtraData(extraData());
        messageDTO.setMsgType(type());
        messageDTO.setFlags(needEncrypt ? 1 : 0);
        return messageDTO;
    }

    public T setTitle(String title) {
        this.message = title;
        return (T) this;
    }

    /**
     * 设置消息是否需要加密,默认false
     *
     * @param needEncrypt 是否需要加密,默认false
     * @return
     */
    public T setNeedEncrypt(boolean needEncrypt) {
        this.needEncrypt = needEncrypt;
        return (T) this;
    }

    /**
     * 消息接收人列表
     *
     * @param receivers
     * @return
     */
    public T setReceivers(Collection<String> receivers) {
        this.receivers = receivers;
        return (T) this;
    }

    /**
     * 加密消息, 推送提醒内容
     *
     * @param pushTips 可选字段
     * @return
     */
    public T setPushTips(String pushTips) {
        this.pushTips = pushTips;
        return (T) this;
    }

    protected String message() {
        return message;
    }

    protected abstract byte type();

    public abstract String validate();

    protected Object extraData() {
        return this;
    }

}
