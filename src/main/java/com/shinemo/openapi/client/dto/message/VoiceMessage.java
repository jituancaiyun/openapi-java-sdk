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
public final class VoiceMessage extends IMessage<VoiceMessage> {
    /**
     * 时长
     */
    private Integer duration;

    public VoiceMessage() {
    }

    public VoiceMessage(String message) {
        super(message);
    }

    @Override
    public String validate() {
        if (duration == null || duration <= 0) return "VoiceMessage.duration 必须大于0";
        return null;
    }

    public Integer getDuration() {
        return duration;
    }

    public VoiceMessage setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public byte type() {
        return 3;
    }
}