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

package com.shinemo.openapi.client.dto;

import java.util.Collection;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class PushMessageDTO {

    /**
     * 0:为加密消息, 1:加密消息
     */
    private int flags;

    /**
     * 消息类型
     */
    private int msgType;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 消息扩展数据Json
     */
    private String extraData;

    /**
     * 发送者ID
     */
    private String fromId;

    /**
     * 发送者名称
     */
    private String fromName;

    /**
     * 群ID
     */
    private Long groupId;

    /**
     * 接收人Uid列表
     */
    private Collection<String> receivers;

    /**
     * 加密密钥ID
     */
    private Integer keyId;

    /**
     * 加密消息, 推送提醒内容
     */
    private String pushTips;

    /**
     * 二级应用ID
     */
    private Integer subAppId;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Collection<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(Collection<String> receivers) {
        this.receivers = receivers;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getPushTips() {
        return pushTips;
    }

    public void setPushTips(String pushTips) {
        this.pushTips = pushTips;
    }

    public Integer getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(Integer subAppId) {
        this.subAppId = subAppId;
    }

    @Override
    public String toString() {
        return "PushMessageDTO{" +
                "flags=" + flags +
                ", msgType=" + msgType +
                ", message='" + message + '\'' +
                ", extraData='" + extraData + '\'' +
                ", receivers=" + receivers +
                ", keyId=" + keyId +
                ", pushTips='" + pushTips + '\'' +
                ", subAppId=" + subAppId +
                ", groupId=" + groupId +
                '}';
    }
}
