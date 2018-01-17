package com.shinemo.openapi.client.dto;

import java.io.Serializable;

public class CreateUserDTO implements Serializable {
    private String uid;
    private String name;
    private Boolean isRemind;
    private Boolean isDelete;
    private Boolean isBindingMail;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsRemind() {
        return isRemind;
    }

    public void setISRemind(Boolean isRemind) {
        this.isRemind = isRemind;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsBindingMail() {
        return isBindingMail;
    }

    public void setIsBindingMail(Boolean isBindingMail) {
        this.isBindingMail = isBindingMail;
    }

    @Override
    public String toString() {
        return "CreateUser{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

