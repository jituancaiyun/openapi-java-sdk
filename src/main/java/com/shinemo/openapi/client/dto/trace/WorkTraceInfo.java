package com.shinemo.openapi.client.dto.trace;

import java.util.ArrayList;

/**
 * @author yuanjian
 * @date 2/1/18
 * @email liuyj@shinemo.com
 */
public class WorkTraceInfo {
    private long contrailId;
    private long orgId;
    private String uid;
    private String userName;
    private long beginTime;
    private long endTime;
    private String beginLocation;
    private String endLocation;
    private double kilometre;
    private String contrails;
    private int endStatus;
    private ArrayList<String> shareUids;
    private String contrailTag = "";

    public long getContrailId() {
        return contrailId;
    }

    public void setContrailId(long contrailId) {
        this.contrailId = contrailId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getBeginLocation() {
        return beginLocation;
    }

    public void setBeginLocation(String beginLocation) {
        this.beginLocation = beginLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getKilometre() {
        return kilometre;
    }

    public void setKilometre(double kilometre) {
        this.kilometre = kilometre;
    }

    public String getContrails() {
        return contrails;
    }

    public void setContrails(String contrails) {
        this.contrails = contrails;
    }

    public int getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(int endStatus) {
        this.endStatus = endStatus;
    }

    public ArrayList<String> getShareUids() {
        return shareUids;
    }

    public void setShareUids(ArrayList<String> shareUids) {
        this.shareUids = shareUids;
    }

    public String getContrailTag() {
        return contrailTag;
    }

    public void setContrailTag(String contrailTag) {
        this.contrailTag = contrailTag;
    }

    @Override
    public String toString() {
        return "WorkTraceInfo{" +
                "contrailId=" + contrailId +
                ", orgId=" + orgId +
                ", uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", beginLocation='" + beginLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", kilometre=" + kilometre +
                ", contrails='" + contrails + '\'' +
                ", endStatus=" + endStatus +
                ", shareUids=" + shareUids +
                ", contrailTag='" + contrailTag + '\'' +
                '}';
    }
}
