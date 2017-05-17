package com.shinemo.openapi.client.dto;

import java.util.ArrayList;

/**
 * Created by yuanjian on 5/15/17.
 */
public class TeamRemindInfo{
    private PersonalRemindDTO.CreateUser creator;
    private TeamRemindDetail detail;

    @Override
    public String toString() {
        return "TeamRemindInfo{" +
                "creator=" + creator +
                ", detail=" + detail +
                '}';
    }

    public PersonalRemindDTO.CreateUser getCreator() {
        return creator;
    }

    public void setCreator(PersonalRemindDTO.CreateUser creator) {
        this.creator = creator;
    }

    public TeamRemindDetail getDetail() {
        return detail;
    }

    public void setDetail(TeamRemindDetail detail) {
        this.detail = detail;
    }

    public class TeamRemindDetail {
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

        @Override
        public String toString() {
            return "TeamRemindDetail{" +
                    "content='" + content + '\'' +
                    ", remindTime=" + remindTime +
                    ", createTime=" + createTime +
                    ", remindType=" + remindType +
                    ", type=" + type +
                    ", isVoiceRemind=" + isVoiceRemind +
                    '}';
        }

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
    }

    public class MemberUser{
        private String uid;
        private String name;
        private int status;
        private boolean isRemind = true;
        private String reply = "";
        private String gmtReply = "";
        private boolean isDelete = false;
        private boolean isBindingMail = false;

        @Override
        public String toString() {
            return "MemberUser{" +
                    "uid='" + uid + '\'' +
                    '}';
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean getIsRemind() {
            return isRemind;
        }

        public void setIsRemind(boolean isRemind) {
            this.isRemind = isRemind;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getGmtReply() {
            return gmtReply;
        }

        public void setGmtReply(String gmtReply) {
            this.gmtReply = gmtReply;
        }

        public boolean getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(boolean isDelete) {
            this.isDelete = isDelete;
        }

        public boolean getIsBindingMail() {
            return isBindingMail;
        }

        public void setIsBindingMail(boolean isBindingMail) {
            this.isBindingMail = isBindingMail;
        }
    }
}
