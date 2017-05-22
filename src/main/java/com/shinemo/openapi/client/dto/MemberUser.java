package com.shinemo.openapi.client.dto;

/**
 * Created by yuanjian on 5/22/17.
 */
public class MemberUser {
    private String uid;
    private String name;
    private int status;
    private boolean isRemind = true;
    private String reply = "";
    private String gmtReply = "";
    private boolean isDelete = false;
    private boolean isBindingMail = false;

    @Override
    public String toString() {
        return "MemberUser{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(boolean isRemind) {
        this.isRemind = isRemind;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getGmtReply() {
        return gmtReply;
    }

    public void setGmtReply(String gmtReply) {
        this.gmtReply = gmtReply;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean getIsBindingMail() {
        return isBindingMail;
    }

    public void setIsBindingMail(boolean isBindingMail) {
        this.isBindingMail = isBindingMail;
    }
}
