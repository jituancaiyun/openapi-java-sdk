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
public final class MultiContentMessage extends IMessage<MultiContentMessage> {
    private String bizName;
    private String title;
    private String[] content;
    private String name;
    private Long time;
    private String action;
    private String color;

    public MultiContentMessage() {
    }

    public MultiContentMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (bizName == null) return "MultiContentMessage.bizName 不能为空";
        if (title == null) return "MultiContentMessage.title 不能为空";
        if (content == null) return "MultiContentMessage.content 不能为空";
        if (time == null) return "MultiContentMessage.time 不能为空";
        return null;
    }

    public String getBizName() {
        return bizName;
    }

    public MultiContentMessage setBizName(String bizName) {
        this.bizName = bizName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public MultiContentMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String[] getContent() {
        return content;
    }

    public MultiContentMessage setContent(String[] content) {
        this.content = content;
        return this;
    }

    public String getName() {
        return name;
    }

    public MultiContentMessage setName(String name) {
        this.name = name;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public MultiContentMessage setTime(Long time) {
        this.time = time;
        return this;
    }

    public String getAction() {
        return action;
    }

    public MultiContentMessage setAction(String action) {
        this.action = action;
        return this;
    }

    public String getColor() {
        return color;
    }

    public MultiContentMessage setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public byte type() {
        return 22;
    }

    @Override
    public String toString() {
        return "MultiContentMessage{" +
                "bizName='" + bizName + '\'' +
                ", title='" + title + '\'' +
                ", content=" + Arrays.toString(content) +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", action='" + action + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
