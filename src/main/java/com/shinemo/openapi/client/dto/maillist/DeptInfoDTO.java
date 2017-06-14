package com.shinemo.openapi.client.dto.maillist;

/**
 * Created by yuanjian on 6/7/17.
 */
public class DeptInfoDTO {
    private String name;
    private Long parentId;
    private Integer order;
    private Long deptId;
    private Long orgId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "DeptInfoDto{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", order=" + order +
                ", deptId=" + deptId +
                ", orgId=" + orgId +
                "}\n";
    }
}
