package com.shinemo.openapi.client.dto.meeting;

import com.shinemo.openapi.client.dto.MemberUser;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/5/17.
 */
public class MeetingInviteDetailDTO {
    private String content;
    private String voiceUrl;
    private Integer voiceLength;
    private String address;
    private Long beginTime;
    private Integer remindMin;
    private Long endTime;
    private Long createTime;
    private Integer remindType;
    private ArrayList<MemberUser> members;
    private ArrayList<Integer> voiceWave;
    private ArrayList<MeetingSignMember> signMembers;
    private boolean isPushMail;
    private Integer comments;
    private Integer signs;
    private boolean isVoiceRemind;
    private Long meetingRoomId;
    private Long roomOrgId;
    private Long roomAddrId;
    private String roomName;
    private Integer meetRoomApproveStatus;
    private String approveId;
    private ArrayList<MemberUser> meetrecoeders;
    private boolean bmeetneed;
    private boolean bleaveopen;
    private Long orgId;
    private Integer isPermitOtherSign;

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

    public boolean isPushMail() {
        return isPushMail;
    }

    public void setPushMail(boolean pushMail) {
        isPushMail = pushMail;
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

    public boolean isVoiceRemind() {
        return isVoiceRemind;
    }

    public void setVoiceRemind(boolean voiceRemind) {
        isVoiceRemind = voiceRemind;
    }

    public Long getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Long meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public Long getRoomOrgId() {
        return roomOrgId;
    }

    public void setRoomOrgId(Long roomOrgId) {
        this.roomOrgId = roomOrgId;
    }

    public Long getRoomAddrId() {
        return roomAddrId;
    }

    public void setRoomAddrId(Long roomAddrId) {
        this.roomAddrId = roomAddrId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getMeetRoomApproveStatus() {
        return meetRoomApproveStatus;
    }

    public void setMeetRoomApproveStatus(Integer meetRoomApproveStatus) {
        this.meetRoomApproveStatus = meetRoomApproveStatus;
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId;
    }

    public ArrayList<MemberUser> getMeetrecoeders() {
        return meetrecoeders;
    }

    public void setMeetrecoeders(ArrayList<MemberUser> meetrecoeders) {
        this.meetrecoeders = meetrecoeders;
    }

    public boolean isBmeetneed() {
        return bmeetneed;
    }

    public void setBmeetneed(boolean bmeetneed) {
        this.bmeetneed = bmeetneed;
    }

    public boolean isBleaveopen() {
        return bleaveopen;
    }

    public void setBleaveopen(boolean bleaveopen) {
        this.bleaveopen = bleaveopen;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getIsPermitOtherSign() {
        return isPermitOtherSign;
    }

    public void setIsPermitOtherSign(Integer isPermitOtherSign) {
        this.isPermitOtherSign = isPermitOtherSign;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"voiceUrl\":\"")
                .append(voiceUrl).append('\"');
        sb.append(",\"voiceLength\":")
                .append(voiceLength);
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"beginTime\":")
                .append(beginTime);
        sb.append(",\"remindMin\":")
                .append(remindMin);
        sb.append(",\"endTime\":")
                .append(endTime);
        sb.append(",\"createTime\":")
                .append(createTime);
        sb.append(",\"remindType\":")
                .append(remindType);
        sb.append(",\"members\":")
                .append(members);
        sb.append(",\"voiceWave\":")
                .append(voiceWave);
        sb.append(",\"signMembers\":")
                .append(signMembers);
        sb.append(",\"isPushMail\":")
                .append(isPushMail);
        sb.append(",\"comments\":")
                .append(comments);
        sb.append(",\"signs\":")
                .append(signs);
        sb.append(",\"isVoiceRemind\":")
                .append(isVoiceRemind);
        sb.append(",\"meetingRoomId\":")
                .append(meetingRoomId);
        sb.append(",\"roomOrgId\":")
                .append(roomOrgId);
        sb.append(",\"roomAddrId\":")
                .append(roomAddrId);
        sb.append(",\"roomName\":\"")
                .append(roomName).append('\"');
        sb.append(",\"meetRoomApproveStatus\":")
                .append(meetRoomApproveStatus);
        sb.append(",\"approveId\":\"")
                .append(approveId).append('\"');
        sb.append(",\"meetrecoeders\":")
                .append(meetrecoeders);
        sb.append(",\"bmeetneed\":")
                .append(bmeetneed);
        sb.append(",\"bleaveopen\":")
                .append(bleaveopen);
        sb.append(",\"orgId\":")
                .append(orgId);
        sb.append(",\"isPermitOtherSign\":")
                .append(isPermitOtherSign);
        sb.append('}');
        return sb.toString();
    }
}
