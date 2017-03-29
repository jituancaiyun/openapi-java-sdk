package com.shinemo.openapi.client.dto;


import java.io.Serializable;

public class ContactDeptDTO implements Serializable {

    private Long id;

    private String name;

    private Long parentid;

    private Long oldParentid;

    private Long orgId;

    private Integer sequence;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getOldParentid() {
        return oldParentid;
    }

    public void setOldParentid(Long oldParentid) {
        this.oldParentid = oldParentid;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "ContactDeptDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentid=" + parentid +
                ", oldParentid=" + oldParentid +
                ", orgId=" + orgId +
                ", sequence=" + sequence +
                '}';
    }
}
