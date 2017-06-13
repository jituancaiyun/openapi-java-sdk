package com.shinemo.openapi.client.dto;


import java.io.Serializable;

public class ContactUserDTO implements Serializable {

    private Long id;
    private String name;
    private String mobile;
    private String title;
    private Long deptId;
    private Integer sequence;

    private Long oldDeptId;

    private Long orgId;

    public Long getId() {
        return id;
    }

    public void setId(Long uid) {
        this.id = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getOldDeptId() {
        return oldDeptId;
    }

    public void setOldDeptId(Long oldDeptId) {
        this.oldDeptId = oldDeptId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "ContactUserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", title='" + title + '\'' +
                ", deptId=" + deptId +
                ", oldDeptId=" + oldDeptId +
                ", orgId=" + orgId +
                "}\n";
    }
}
