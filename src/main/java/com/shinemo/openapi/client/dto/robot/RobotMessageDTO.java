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

package com.shinemo.openapi.client.dto.robot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Created by ohun on 2017/10/23.
 *
 * @author ohun@live.cn (夜色)
 */
public final class RobotMessageDTO {

    private String uid;

    private Long groupId;

    private String msg;
    /**
     * 消息类型
     */
    private Integer msgType;

    @JsonProperty("extraData")
    private String extMsg;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getExtMsg() {
        return extMsg;
    }

    public void setExtMsg(String extMsg) {
        this.extMsg = extMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotMessageDTO that = (RobotMessageDTO) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(msg, that.msg) &&
                Objects.equals(msgType, that.msgType) &&
                Objects.equals(extMsg, that.extMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, groupId, msg, msgType, extMsg);
    }

    @Override
    public String toString() {
        return "RobotMessageDTO{" +
                "uid='" + uid + '\'' +
                ", groupId=" + groupId +
                ", msg='" + msg + '\'' +
                ", msgType=" + msgType +
                ", extMsg='" + extMsg + '\'' +
                '}';
    }
}
