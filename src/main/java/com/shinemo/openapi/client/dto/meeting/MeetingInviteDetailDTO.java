package com.shinemo.openapi.client.dto.meeting;

import com.shinemo.openapi.client.dto.MemberUser;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/5/17.
 */
public class MeetingInviteDetailDTO {
    private String content;
    private String voiceUrl;
    private int voiceLength;
    private String address;
    private Long beginTime;
    private Integer remindMin;
    private Long endTime;
    private Long createTime;
    private Integer remindType;
    private ArrayList<MemberUser> members;
    private ArrayList<Integer> voiceWave;
    private ArrayList<MeetingSignMember> signMembers;
    private Boolean isPushMail = false;
    private Integer comments = 0;
    private Integer signs = 0;

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

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getRemindMin() {
        return remindMin;
    }

    public void setRemindMin(Integer remindMin) {
        this.remindMin = remindMin;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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

    public Boolean getIsPushMail() {
        return isPushMail;
    }

    public void setIsPushMail(Boolean isPushMail) {
        this.isPushMail = isPushMail;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getSigns() {
        return signs;
    }

    public void setSigns(Integer signs) {
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
