package com.shinemo.openapi.client.dto;

public class CreateUserDTO {
    private String uid;
    private String name;
    private boolean isRemind = true;
    private boolean isDelete = false;
    private boolean isBindingMail = false;

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

    public boolean isRemind() {
        return isRemind;
    }

    public void setRemind(boolean remind) {
        isRemind = remind;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isBindingMail() {
        return isBindingMail;
    }

    public void setBindingMail(boolean bindingMail) {
        isBindingMail = bindingMail;
    }

    @Override
    public String toString() {
        return "CreateUser{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

