package com.shinemo.openapi.client.dto;


import java.io.Serializable;
import java.util.List;

public class ContactDTO implements Serializable {

    private List<ContactDeptDTO> departments;

    private List<ContactUserDTO> users;

    private boolean hasMore;


    public List<ContactDeptDTO> getDepartments() {
        return departments;
    }

    public void setDepartments(List<ContactDeptDTO> departments) {
        this.departments = departments;
    }

    public List<ContactUserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<ContactUserDTO> users) {
        this.users = users;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "departments=" + departments +
                ", users=" + users +
                ", hasMore=" + hasMore +
                "}\n";
    }
}
