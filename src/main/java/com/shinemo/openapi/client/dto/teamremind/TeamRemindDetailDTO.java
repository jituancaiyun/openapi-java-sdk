package com.shinemo.openapi.client.dto.teamremind;

import com.shinemo.openapi.client.dto.MemberUser;
import com.shinemo.openapi.client.dto.personalremind.RFrequency;

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
    private ArrayList<Integer> voiceWave;
    protected RFrequency rfrequency;
    private Boolean isPushMail = false;
    private Boolean isVoiceRemind = false;
    protected boolean isTimingSend = true;
    protected long sendTime = 0L;

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

    public Boolean getPushMail() {
        return isPushMail;
    }

    public void setPushMail(Boolean pushMail) {
        isPushMail = pushMail;
    }

    public Boolean getVoiceRemind() {
        return isVoiceRemind;
    }

    public void setVoiceRemind(Boolean voiceRemind) {
        isVoiceRemind = voiceRemind;
    }

    public boolean isTimingSend() {
        return isTimingSend;
    }

    public void setTimingSend(boolean timingSend) {
        isTimingSend = timingSend;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public RFrequency getRfrequency() {
        return rfrequency;
    }

    public void setRfrequency(RFrequency rfrequency) {
        this.rfrequency = rfrequency;
    }

    @Override
    public String toString() {
        return "TeamRemindDetailDTO{" +
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
                ", isTimingSend=" + isTimingSend +
                ", sendTime=" + sendTime +
                '}';
    }
}
