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

import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiUtils;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public class AppMessage extends IMessage<AppMessage> {
    private String content;
    private String from;
    private String fromIcon;
    private Byte isShare;
    private String action;
    private String title;
    private String preTitle;
    private String color;
    private Integer unreadCount;
    private Integer appId;
    private Long orgId;

    public AppMessage() {
    }

    public AppMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (title == null) return "AppMessage.title 不能为空";
        if (content == null) return "AppMessage.content 不能为空";
        return null;
    }

    public String getContent() {
        return content;
    }

    public AppMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public AppMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getFromIcon() {
        return fromIcon;
    }

    public AppMessage setFromIcon(String fromIcon) {
        this.fromIcon = fromIcon;
        return this;
    }

    public Byte getIsShare() {
        return isShare;
    }

    public AppMessage setIsShare(Byte isShare) {
        this.isShare = isShare;
        return this;
    }

    public String getAction() {
        return action;
    }

    public AppMessage setAction(String action) {
        this.action = action;
        return this;
    }

    public AppMessage setUrlAction(String url) {
        return setUrlAction(url, null);
    }

    public AppMessage setUrlAction(String url, String param) {
        if (appId == null) throw new OpenApiException("AppMessage.appId 不能为空");
        if (orgId == null) throw new OpenApiException("AppMessage.orgId 不能为空");
        if (url == null) throw new OpenApiException("url 不能为空");

        return this.setAction(Action.buildOpenUrlAction(url, param, appId, orgId));
    }

    public String getTitle() {
        return title;
    }

    @Override
    public AppMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPreTitle() {
        return preTitle;
    }

    public AppMessage setPreTitle(String preTitle) {
        this.preTitle = preTitle;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AppMessage setColor(String color) {
        this.color = color;
        return this;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public AppMessage setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
        return this;
    }

    public Integer getAppId() {
        return appId;
    }

    public AppMessage setAppId(Integer appId) {
        this.appId = appId;
        return this;
    }

    public Long getOrgId() {
        return orgId;
    }

    public AppMessage setOrgId(String orgId) {
        this.orgId = OpenApiUtils.getOrgId(orgId);
        return this;
    }

    @Override
    public byte type() {
        return 18;
    }

    @Override
    public String toString() {
        return "AppMessage{" +
                "content='" + content + '\'' +
                ", from='" + from + '\'' +
                ", fromIcon='" + fromIcon + '\'' +
                ", isShare=" + isShare +
                ", action='" + action + '\'' +
                ", title='" + title + '\'' +
                ", preTitle='" + preTitle + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
