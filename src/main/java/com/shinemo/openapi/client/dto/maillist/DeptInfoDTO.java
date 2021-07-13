package com.shinemo.openapi.client.dto.maillist;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/7/17.
 */
public class DeptInfoDTO {
    private Long parentId;
    private String name;
    private int order;
    private long deptId;
    private long orgId;
    private String externalId;
    private ArrayList<Long> uids;
    private boolean judgeExist;
    private String principalName;
    private String parentIds;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ArrayList<Long> getUids() {
        return uids;
    }

    public void setUids(ArrayList<Long> uids) {
        this.uids = uids;
    }

    public boolean isJudgeExist() {
        return judgeExist;
    }

    public void setJudgeExist(boolean judgeExist) {
        this.judgeExist = judgeExist;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "DeptInfoDTO{" +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", deptId=" + deptId +
                ", orgId=" + orgId +
                ", externalId='" + externalId + '\'' +
                ", uids=" + uids +
                ", judgeExist=" + judgeExist +
                ", principalName='" + principalName + '\'' +
                ", parentIds='" + parentIds + '\'' +
                '}';
    }
}
