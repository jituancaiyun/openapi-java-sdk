package com.shinemo.openapi.client.dto;

import java.io.Serializable;
import java.util.List;

public class UserInfoDTO implements Serializable {

    private String uid;
    private String mobile;
    private String avatar;
    private String name;
    private String orgId;
    private String orgSecret;
    private String orgName;
    private List<OrgDTO> orgList;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrgDTO> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OrgDTO> orgList) {
        this.orgList = orgList;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgSecret() {
        return orgSecret;
    }

    public void setOrgSecret(String orgSecret) {
        this.orgSecret = orgSecret;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", avatar='" + avatar + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgSecret='" + orgSecret + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgList=" + orgList +
                '}';
    }
}
