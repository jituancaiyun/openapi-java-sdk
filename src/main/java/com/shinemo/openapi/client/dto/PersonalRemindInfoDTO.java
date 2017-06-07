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

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ohun on 2017/3/22.
 *
 * @author ohun@live.cn (夜色)
 */
public class PersonalRemindInfoDTO implements Serializable {

    private CreateUserDTO createUser;
    private PersonalRemindDTO personalRemind;

    public CreateUserDTO getCreateUser() {
        return createUser;
    }

    public void setCreateUser(CreateUserDTO createUser) {
        this.createUser = createUser;
    }

    public PersonalRemindDTO getPersonalRemind() {
        return personalRemind;
    }

    public void setPersonalRemind(PersonalRemindDTO personalRemind) {
        this.personalRemind = personalRemind;
    }

    @Override
    public String toString() {
        return "PersonalRemindInfoDTO{" +
                "createUser=" + createUser +
                ", personalRemind=" + personalRemind +
                '}';
    }

    public class PersonalRemindDTO{
        private int remindType;
        private long remindTime;
        private String content;
        private int fromSource;
        private String extra;
        private RAttachment attachment;
        private RFrequency rfrequency;
        private boolean isVoiceRemind;

        public int getRemindType() {
            return remindType;
        }

        public void setRemindType(int remindType) {
            this.remindType = remindType;
        }

        public long getRemindTime() {
            return remindTime;
        }

        public void setRemindTime(long remindTime) {
            this.remindTime = remindTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getFromSource() {
            return fromSource;
        }

        public void setFromSource(int fromSource) {
            this.fromSource = fromSource;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }

        public RAttachment getAttachment() {
            return attachment;
        }

        public void setAttachment(RAttachment attachment) {
            this.attachment = attachment;
        }

        public RFrequency getRfrequency() {
            return rfrequency;
        }

        public void setRfrequency(RFrequency rfrequency) {
            this.rfrequency = rfrequency;
        }

        public boolean getIsVoiceRemind() {
            return isVoiceRemind;
        }

        public void setIsVoiceRemind(boolean isVoiceRemind) {
            this.isVoiceRemind = isVoiceRemind;
        }

        @Override
        public String toString() {
            return "PersonalRemind{" +
                    "remindType=" + remindType +
                    ", remindTime=" + remindTime +
                    ", content='" + content + '\'' +
                    ", fromSource=" + fromSource +
                    ", extra='" + extra + '\'' +
                    ", rfrequency=" + rfrequency +
                    ", isVoiceRemind=" + isVoiceRemind +
                    '}';
        }
    }

    public class RAttachment implements Serializable {
        protected int duration;
        protected String url;
        protected ArrayList<Integer> voiceBand;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ArrayList<Integer> getVoiceBand() {
            return voiceBand;
        }

        public void setVoiceBand(ArrayList<Integer> voiceBand) {
            this.voiceBand = voiceBand;
        }

        @Override
        public String toString() {
            return "RAttachment{" +
                    "duration=" + duration +
                    ", url='" + url + '\'' +
                    ", voiceBand=" + voiceBand +
                    '}';
        }
    }

    public class RFrequency implements Serializable {
        protected int type = -1;
        protected String remindTime;

        @Override
        public String toString() {
            return "RFrequency{" +
                    "type=" + type +
                    ", remindTime='" + remindTime + '\'' +
                    '}';
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRemindTime() {
            return remindTime;
        }

        public void setRemindTime(String remindTime) {
            this.remindTime = remindTime;
        }
    }

}
