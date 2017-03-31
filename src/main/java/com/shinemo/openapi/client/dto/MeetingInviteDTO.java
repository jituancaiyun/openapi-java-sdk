package com.shinemo.openapi.client.dto;


public class MeetingInviteDTO {

    private String requesterUid;

    private String requesterName;

    private Long orgId;

    private Integer orgType;

    private String createrId;

    private String createrName;

    private Long meetingInviteId;

    private Integer pushStatus;

    private MeetingDetailDTO detail;

    public String getRequesterUid() {
        return requesterUid;
    }

    public void setRequesterUid(String requesterUid) {
        this.requesterUid = requesterUid;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Long getMeetingInviteId() {
        return meetingInviteId;
    }

    public void setMeetingInviteId(Long meetingInviteId) {
        this.meetingInviteId = meetingInviteId;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public MeetingDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(MeetingDetailDTO detail) {
        this.detail = detail;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }
}
