package com.shinemo.openapi.client.dto.maillist;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/14/17.
 */
public class PrivilegeGroupDTO {
    private Long id;
    private String name;
    private Integer isolation;
    private ArrayList<Long> deptList;
    private ArrayList<Long> userList;

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

    public Integer getIsolation() {
        return isolation;
    }

    public void setIsolation(Integer isolation) {
        this.isolation = isolation;
    }

    public ArrayList<Long> getDeptList() {
        return deptList;
    }

    public void setDeptList(ArrayList<Long> deptList) {
        this.deptList = deptList;
    }

    public ArrayList<Long> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Long> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "PrivilegeGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isolation=" + isolation +
                ", deptList=" + deptList +
                ", userList=" + userList +
                '}';
    }
}
