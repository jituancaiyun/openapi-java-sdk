package com.shinemo.openapi.client.dto;


import java.io.Serializable;

public class OrgDTO implements Serializable {

    private String orgName;
    private String orgId;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "OrgDTO{" +
                "orgName='" + orgName + '\'' +
                ", orgId='" + orgId + '\'' +
                '}';
    }
}
