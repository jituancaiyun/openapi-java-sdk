package com.shinemo.openapi.client.dto.meeting;


import com.shinemo.openapi.client.dto.CreateUserDTO;

public class MeetingInviteInfoDTO {
    private CreateUserDTO creator = new CreateUserDTO();
    private Integer status;
    private MeetingInviteDetailDTO detail = new MeetingInviteDetailDTO();
    private Integer signModel = 0;
    private Boolean isSign = false;
    private Long remindAgainTime = 0L;

    public CreateUserDTO getCreator() {
        return creator;
    }

    public void setCreator(CreateUserDTO creator) {
        this.creator = creator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public MeetingInviteDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(MeetingInviteDetailDTO detail) {
        this.detail = detail;
    }

    public Integer getSignModel() {
        return signModel;
    }

    public void setSignModel(Integer signModel) {
        this.signModel = signModel;
    }

    public Boolean getIsSign() {
        return this.isSign;
    }

    public void setSign(Boolean isSign) {
        this.isSign = isSign;
    }

    public Long getRemindAgainTime() {
        return remindAgainTime;
    }

    public void setRemindAgainTime(Long remindAgainTime) {
        this.remindAgainTime = remindAgainTime;
    }

    @Override
    public String toString() {
        return "MeetingInviteInfo{" +
                "creator=" + creator +
                ", status=" + status +
                ", detail=" + detail +
                ", signModel=" + signModel +
                ", isSign=" + isSign +
                ", remindAgainTime=" + remindAgainTime +
                '}';
    }
}

