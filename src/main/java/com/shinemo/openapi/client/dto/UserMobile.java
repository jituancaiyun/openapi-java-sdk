package com.shinemo.openapi.client.dto;

/**
 * @author yuanjian
 * @date 1/10/18
 * @email liuyj@shinemo.com
 */
public class UserMobile {

    private long uid;
    private String mobile;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserMobile{" +
                "uid=" + uid +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
