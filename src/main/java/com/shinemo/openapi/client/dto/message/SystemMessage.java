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

import java.util.Arrays;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class SystemMessage extends IMessage<SystemMessage> {
    private String title;
    private String content;
    private String[] desc;
    private String action;
    private String color;

    public SystemMessage() {
    }

    public SystemMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (title == null) return "SystemMessage.title 不能为空";
        //if (desc == null) return "SystemMessage.desc 不能为空";
        if (content == null) return "SystemMessage.content 不能为空";
        return null;
    }

    public String getTitle() {
        return title;
    }

    public SystemMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String[] getDesc() {
        return desc;
    }

    public SystemMessage setDesc(String... desc) {
        this.desc = desc;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SystemMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAction() {
        return action;
    }

    public SystemMessage setAction(String action) {
        this.action = action;
        return this;
    }

    public String getColor() {
        return color;
    }

    public SystemMessage setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public byte type() {
        return 25;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", desc=" + Arrays.toString(desc) +
                ", action='" + action + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
