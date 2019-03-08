package com.shinemo.openapi.client.dto.schedule;

import com.shinemo.openapi.client.dto.CreateUserDTO;

/**
 * Created by yuanjian on 12/5/18
 *
 * @author liuyj@shinemo.com
 */
public class ScheduleShareInfo {
    private CreateUserDTO creator;
    private int status;
    private String remark;
    private long remarktime;
    private ScheduleDetail detail;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getRemarktime() {
        return remarktime;
    }

    public void setRemarktime(long remarktime) {
        this.remarktime = remarktime;
    }

    public ScheduleDetail getDetail() {
        return detail;
    }

    public void setDetail(ScheduleDetail detail) {
        this.detail = detail;
    }
}
