package com.shinemo.openapi.client.dto.personalremind;

import java.io.Serializable;

/**
 * Created by yuanjian on 6/20/17.
 */
public class PersonalRemindDTO implements Serializable {
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
