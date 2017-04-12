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
public final class CalMessage extends IMessage<CalMessage> {
    private String audioUrl;
    private Integer duration;
    private String uid;
    private String name;
    private Long time;

    public CalMessage() {
    }

    public CalMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (audioUrl == null) return "CalMessage.audioUrl 不能为空";
        if (duration == null || duration <= 0) return "CalMessage.duration 必须大于0";
        if (uid == null) return "CalMessage.uid 不能为空";
        if (time == null) return "CalMessage.time 不能为空";
        return null;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public CalMessage setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public CalMessage setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public CalMessage setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public CalMessage setName(String name) {
        this.name = name;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public CalMessage setTime(Long time) {
        this.time = time;
        return this;
    }

    @Override
    public byte type() {
        return 17;
    }

}
