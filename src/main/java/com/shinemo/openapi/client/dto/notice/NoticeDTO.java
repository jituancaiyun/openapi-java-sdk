package com.shinemo.openapi.client.dto.notice;

import java.util.ArrayList;

/**
 * 公告
 *
 * @author yuanjian
 * @date 1/8/18
 * @email liuyj@shinemo.com
 */
public class NoticeDTO {
    private long orgId;
    private String content;
    private String title;
    private boolean isAllSend;
    private boolean isSmsRemind;
    private ArrayList<Long> deptList;
    private ArrayList<Long> userList;
    private ArrayList<Annex> annexes;
    private String imgUrl;
    private boolean isWaterMark;

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAllSend() {
        return isAllSend;
    }

    public void setAllSend(boolean allSend) {
        isAllSend = allSend;
    }

    public boolean isSmsRemind() {
        return isSmsRemind;
    }

    public void setSmsRemind(boolean smsRemind) {
        isSmsRemind = smsRemind;
    }

    public ArrayList<Long> getDeptList() {
        return deptList;
    }

    public void setDeptList(ArrayList<Long> deptList) {
        this.deptList = deptList;
    }

    public ArrayList<Long> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Long> userList) {
        this.userList = userList;
    }

    public ArrayList<Annex> getAnnexes() {
        return annexes;
    }

    public void setAnnexes(ArrayList<Annex> annexes) {
        this.annexes = annexes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isWaterMark() {
        return isWaterMark;
    }

    public void setWaterMark(boolean waterMark) {
        isWaterMark = waterMark;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "orgId=" + orgId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", isAllSend=" + isAllSend +
                ", isSmsRemind=" + isSmsRemind +
                ", deptList=" + deptList +
                ", userList=" + userList +
                ", annexes=" + annexes +
                ", imgUrl='" + imgUrl + '\'' +
                ", isWaterMark=" + isWaterMark +
                '}';
    }
}
