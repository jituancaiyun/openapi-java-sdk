package com.shinemo.openapi.client.dto.meeting;

import com.shinemo.openapi.client.dto.MemberUser;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/5/17.
 */
public class MeetingInviteDetailDTO {
    private String content;
    private String voiceUrl;
    private int voiceLength;
    private String address;
    private long beginTime;
    private int remindMin;
    private long endTime;
    private long createTime;
    private int remindType;
    private ArrayList<MemberUser> members;
    private ArrayList<Integer> voiceWave;
    private ArrayList<MeetingSignMember> signMembers;
    private boolean isPushMail = false;
    private int comments = 0;
    private int signs = 0;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public int getRemindMin() {
        return remindMin;
    }

    public void setRemindMin(int remindMin) {
        this.remindMin = remindMin;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
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

    public ArrayList<MeetingSignMember> getSignMembers() {
        return signMembers;
    }

    public void setSignMembers(ArrayList<MeetingSignMember> signMembers) {
        this.signMembers = signMembers;
    }

    public boolean isPushMail() {
        return isPushMail;
    }

    public void setPushMail(boolean pushMail) {
        isPushMail = pushMail;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getSigns() {
        return signs;
    }

    public void setSigns(int signs) {
        this.signs = signs;
    }

    @Override
    public String toString() {
        return "MeetingInviteDetail{" +
                "content='" + content + '\'' +
                ", voiceUrl='" + voiceUrl + '\'' +
                ", voiceLength=" + voiceLength +
                ", address='" + address + '\'' +
                ", beginTime=" + beginTime +
                ", remindMin=" + remindMin +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", remindType=" + remindType +
                ", members=" + members +
                ", comments=" + comments +
                '}';
    }
}
