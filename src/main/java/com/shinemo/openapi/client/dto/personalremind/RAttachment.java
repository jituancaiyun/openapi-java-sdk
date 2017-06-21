package com.shinemo.openapi.client.dto.personalremind;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yuanjian on 6/20/17.
 */
public class RAttachment implements Serializable {
    protected int duration;
    protected String url;
    protected ArrayList<Integer> voiceBand;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Integer> getVoiceBand() {
        return voiceBand;
    }

    public void setVoiceBand(ArrayList<Integer> voiceBand) {
        this.voiceBand = voiceBand;
    }

    @Override
    public String toString() {
        return "RAttachment{" +
                "duration=" + duration +
                ", url='" + url + '\'' +
                ", voiceBand=" + voiceBand +
                '}';
    }
}
