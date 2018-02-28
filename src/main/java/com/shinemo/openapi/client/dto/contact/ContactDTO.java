package com.shinemo.openapi.client.dto.contact;

import java.util.List;

/**
 * 通讯录导入-企业
 *
 * @author yuanjian
 * date 1/22/18
 * email liuyj@shinemo.com
 */
public class ContactDTO {

    private List<Dept> deptList;
    private List<User> userList;

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "deptList=" + deptList +
                ", userList=" + userList +
                '}';
    }
}
