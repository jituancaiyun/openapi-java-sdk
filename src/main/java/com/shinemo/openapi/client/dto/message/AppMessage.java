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
public final class AppMessage extends IMessage<AppMessage> {
    private String content;
    private String url;
    private String from;
    private String fromIcon;
    private Byte isShare;
    private String action;
    private String title;
    private String preTitle;
    private String color;

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

    public String getUrl() {
        return url;
    }

    public AppMessage setUrl(String url) {
        this.url = url;
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

    public String getTitle() {
        return title;
    }

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

    @Override
    public byte type() {
        return 18;
    }


    public static class ActionParam {

    }
}
