package com.shinemo.openapi.client.dto;


import java.io.Serializable;

public class OrgDTO  implements Serializable {

    private String orgName;
    private long orgId;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "OrgDTO{" +
                "orgName='" + orgName + '\'' +
                ", orgId=" + orgId +
                '}';
    }
}
