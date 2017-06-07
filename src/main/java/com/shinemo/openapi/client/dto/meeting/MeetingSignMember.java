package com.shinemo.openapi.client.dto.meeting;

/**
 * Created by yuanjian on 6/5/17.
 */
public class MeetingSignMember {
    protected String uid;
    protected String name;
    protected long signTime = 0;

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

    public long getSignTime() {
        return signTime;
    }

    public void setSignTime(long signTime) {
        this.signTime = signTime;
    }

    @Override
    public String toString() {
        return "MeetingSignMember{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", signTime=" + signTime +
                '}';
    }
}
