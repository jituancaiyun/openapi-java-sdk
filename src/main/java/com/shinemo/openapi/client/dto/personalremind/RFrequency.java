package com.shinemo.openapi.client.dto.personalremind;

import java.io.Serializable;

/**
 * Created by yuanjian on 6/20/17.
 */
public class RFrequency implements Serializable {
    protected int type = -1;
    protected String remindTime;

    @Override
    public String toString() {
        return "RFrequency{" +
                "type=" + type +
                ", remindTime='" + remindTime + '\'' +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }
}
