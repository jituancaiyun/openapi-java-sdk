package com.shinemo.openapi.client.dto.meeting;


import com.shinemo.openapi.client.dto.CreateUserDTO;

public class MeetingInviteInfoDTO {
    private CreateUserDTO creator = new CreateUserDTO();
    private int status;
    private MeetingInviteDetailDTO detail = new MeetingInviteDetailDTO();
    private int signModel = 0;
    private boolean isSign = false;
    private long remindAgainTime = 0;

    public CreateUserDTO getCreator() {
        return creator;
    }

    public void setCreator(CreateUserDTO creator) {
        this.creator = creator;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MeetingInviteDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(MeetingInviteDetailDTO detail) {
        this.detail = detail;
    }

    public int getSignModel() {
        return signModel;
    }

    public void setSignModel(int signModel) {
        this.signModel = signModel;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    public long getRemindAgainTime() {
        return remindAgainTime;
    }

    public void setRemindAgainTime(long remindAgainTime) {
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

