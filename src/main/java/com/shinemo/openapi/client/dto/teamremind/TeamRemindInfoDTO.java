package com.shinemo.openapi.client.dto.teamremind;

import com.shinemo.openapi.client.dto.CreateUserDTO;

/**
 * Created by yuanjian on 6/6/17.
 */
public class TeamRemindInfoDTO {
    private CreateUserDTO creator = new CreateUserDTO();
    private TeamRemindDetailDTO detail = new TeamRemindDetailDTO();

    public CreateUserDTO getCreator() {
        return creator;
    }

    public void setCreator(CreateUserDTO creator) {
        this.creator = creator;
    }

    public TeamRemindDetailDTO getDetail() {
        return detail;
    }

    public void setDetail(TeamRemindDetailDTO detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "TeamRemindInfo{" +
                "creator=" + creator +
                ", detail=" + detail +
                '}';
    }
}
