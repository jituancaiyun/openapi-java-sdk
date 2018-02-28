package com.shinemo.openapi.client.dto.role;

/**
 * 企业权限列表
 *
 * @author yuanjian
 * date 2/27/18
 * email liuyj@shinemo.com
 */
public class OrgRole {
    private int roleId;
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "OrgRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
