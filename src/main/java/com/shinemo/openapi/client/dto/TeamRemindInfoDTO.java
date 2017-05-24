package com.shinemo.openapi.client.dto;

import java.util.ArrayList;

/**
 * Created by yuanjian on 5/15/17.
 */
public class TeamRemindInfoDTO{
    private PersonalRemindInfoDTO.CreateUserDTO creator;
    private TeamRemindDetailDTO detail;

    @Override
    public String toString() {
        return "TeamRemindInfo{" +
                "creator=" + creator +
                ", detail=" + detail +
                '}';
    }

    public PersonalRemindInfoDTO.CreateUserDTO getCreator() {
        return creator;
    }

    public void setCreator(PersonalRemindInfoDTO.CreateUserDTO creator) {
        this.creator = creator;
    }

    public TeamRemindDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(TeamRemindDetailDTO detail) {
        this.detail = detail;
    }

    public class TeamRemindDetailDTO {
        private String content;
        private String voiceUrl;
        private int voiceLength;
        private long remindTime;
        private long createTime;
        private int remindType;
        private int type;
        private int fromSource;
        private String extra;
        private ArrayList<MemberUser> members;
        private ArrayList<Integer> voiceWave;
        private boolean isPushMail;

        private boolean isVoiceRemind;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getVoiceUrl() {
            return voiceUrl;
        }

        public void setVoiceUrl(String voiceUrl) {
            this.voiceUrl = voiceUrl;
        }

        public int getVoiceLength() {
            return voiceLength;
        }

        public void setVoiceLength(int voiceLength) {
            this.voiceLength = voiceLength;
        }

        public long getRemindTime() {
            return remindTime;
        }

        public void setRemindTime(long remindTime) {
            this.remindTime = remindTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getRemindType() {
            return remindType;
        }

        public void setRemindType(int remindType) {
            this.remindType = remindType;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public ArrayList<MemberUser> getMembers() {
            return members;
        }

        public void setMembers(ArrayList<MemberUser> members) {
            this.members = members;
        }

        public ArrayList<Integer> getVoiceWave() {
            return voiceWave;
        }

        public void setVoiceWave(ArrayList<Integer> voiceWave) {
            this.voiceWave = voiceWave;
        }

        public boolean isPushMail() {
            return isPushMail;
        }

        public void setPushMail(boolean pushMail) {
            isPushMail = pushMail;
        }

        public boolean getIsVoiceRemind() {
            return isVoiceRemind;
        }

        public void setIsVoiceRemind(boolean isVoiceRemind) {
            this.isVoiceRemind = isVoiceRemind;
        }

        @Override
        public String toString() {
            return "TeamRemindDetail{" +
                    "content='" + content + '\'' +
                    ", voiceUrl='" + voiceUrl + '\'' +
                    ", voiceLength=" + voiceLength +
                    ", remindTime=" + remindTime +
                    ", createTime=" + createTime +
                    ", remindType=" + remindType +
                    ", type=" + type +
                    ", fromSource=" + fromSource +
                    ", extra='" + extra + '\'' +
                    ", members=" + members +
                    ", voiceWave=" + voiceWave +
                    ", isPushMail=" + isPushMail +
                    ", isVoiceRemind=" + isVoiceRemind +
                    '}';
        }
    }

}
