package com.shinemo.openapi.client.dto;


import java.util.List;

public class MeetingDetailDTO {

    private Long createTime;

    private String content;

    private String address;

    private Long beginTime;

    private Long endTime;

    private Integer remindMin;

    private Integer remindType;

    private List<MembersDTO> members;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getRemindMin() {
        return remindMin;
    }

    public void setRemindMin(Integer remindMin) {
        this.remindMin = remindMin;
    }

    public Integer getRemindType() {
        return remindType;
    }

    public void setRemindType(Integer remindType) {
        this.remindType = remindType;
    }

    public List<MembersDTO> getMembers() {
        return members;
    }

    public void setMembers(List<MembersDTO> members) {
        this.members = members;
    }
}
