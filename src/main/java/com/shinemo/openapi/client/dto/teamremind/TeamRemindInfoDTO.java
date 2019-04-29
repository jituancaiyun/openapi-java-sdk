package com.shinemo.openapi.client.dto.teamremind;

import com.shinemo.openapi.client.dto.CreateUserDTO;

/**
 * Created by yuanjian on 6/6/17.
 */
public class TeamRemindInfoDTO {
    private CreateUserDTO creator = new CreateUserDTO();
    /**
     * 0:未推送, 1.已推送, 2.已取消, 4.团队通知撤回
     */
    private Integer status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeamRemindInfoDTO{" +
                "creator=" + creator +
                ", status=" + status +
                ", detail=" + detail +
                '}';
    }
}
