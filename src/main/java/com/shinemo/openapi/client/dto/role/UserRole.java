package com.shinemo.openapi.client.dto.role;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户权限
 *
 * @author yuanjian
 * date 2/27/18
 * email liuyj@shinemo.com
 */
public class UserRole {
    private String mobile;
    private String username;
    private String uid;
    private int role;
    private ArrayList<Long> deptIds;
    private int isMainAdmin = 0;
    private String createUser = "";
    private long adminId = 0L;
    private ArrayList<Integer> roles;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public ArrayList<Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(ArrayList<Long> deptIds) {
        this.deptIds = deptIds;
    }

    public int getIsMainAdmin() {
        return isMainAdmin;
    }

    public void setIsMainAdmin(int isMainAdmin) {
        this.isMainAdmin = isMainAdmin;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public ArrayList<Integer> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Integer> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "mobile='" + mobile + '\'' +
                ", username='" + username + '\'' +
                ", uid='" + uid + '\'' +
                ", role=" + role +
                ", deptIds=" + deptIds +
                ", isMainAdmin=" + isMainAdmin +
                ", createUser='" + createUser + '\'' +
                ", adminId=" + adminId +
                ", roles=" + roles +
                '}';
    }
}
