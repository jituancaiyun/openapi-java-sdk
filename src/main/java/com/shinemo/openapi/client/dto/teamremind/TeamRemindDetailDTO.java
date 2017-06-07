package com.shinemo.openapi.client.dto.teamremind;

import com.shinemo.openapi.client.dto.MemberUser;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/6/17.
 */
public class TeamRemindDetailDTO {
    private String content;
    private String voiceUrl;
    private Integer voiceLength;
    private Long remindTime;
    private Long createTime;
    private Integer remindType;
    private Integer type;
    private Integer fromSource = 0;
    private String extra = "";
    private ArrayList<MemberUser> members;
    private ArrayList< Integer > voiceWave;
    private Boolean isPushMail = false;
    private Boolean isVoiceRemind = false;

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

    public Integer getVoiceLength() {
        return voiceLength;
    }

    public void setVoiceLength(Integer voiceLength) {
        this.voiceLength = voiceLength;
    }

    public Long getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Long remindTime) {
        this.remindTime = remindTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getRemindType() {
        return remindType;
    }

    public void setRemindType(Integer remindType) {
        this.remindType = remindType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFromSource() {
        return fromSource;
    }

    public void setFromSource(Integer fromSource) {
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

    public Boolean getIsPushMail() {
        return isPushMail;
    }

    public void setIsPushMail(Boolean isPushMail) {
        this.isPushMail = isPushMail;
    }

    public Boolean getIsVoiceRemind() {
        return isVoiceRemind;
    }

    public void setIsVoiceRemind(Boolean isVoiceRemind) {
        this.isVoiceRemind = isVoiceRemind;
    }

    @Override
    public String toString() {
        return "TeamRemindDetailDTO{" +
                "content='" + content + '\'' +
                ", remindTime=" + remindTime +
                ", createTime=" + createTime +
                ", remindType=" + remindType +
                ", type=" + type +
                ", members=" + members +
                ", isVoiceRemind=" + isVoiceRemind +
                '}';
    }
}
