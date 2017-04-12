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

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class EmailMessage extends IMessage<EmailMessage> {
    private String mContent;
    private String mUrl;
    private Byte isShare;
    private Long sendTime;
    private String sender;

    public EmailMessage() {
    }

    public EmailMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (mContent == null) return "EmailMessage.mContent 不能为空";
        if (mUrl == null) return "EmailMessage.mUrl 不能为空";
        if (sendTime == null) return "EmailMessage.sendTime 不能为空";
        if (sender == null) return "EmailMessage.sender 不能为空";
        return null;
    }

    public String getmContent() {
        return mContent;
    }

    public EmailMessage setmContent(String mContent) {
        this.mContent = mContent;
        return this;
    }

    public String getmUrl() {
        return mUrl;
    }

    public EmailMessage setmUrl(String mUrl) {
        this.mUrl = mUrl;
        return this;
    }

    public Byte getIsShare() {
        return isShare;
    }

    public EmailMessage setIsShare(Byte isShare) {
        this.isShare = isShare;
        return this;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public EmailMessage setSendTime(Long sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public EmailMessage setSender(String sender) {
        this.sender = sender;
        return this;
    }

    @Override
    public byte type() {
        return 16;
    }
}
