package com.shinemo.openapi.client.dto.maillist;

/**
 * Created by yuanjian on 6/12/17.
 */
public class UserInfoDTO {
    private long id;
    private String name;
    private String mobile;
    private String title;
    private long orgId;
    private int sequence;
    private int isAdmin;
    private String workPhone;
    private String virtualCode;
    private String shortNum;
    private String email;
    private String fax;
    private long deptId;
    private String externalId = "";
    private String externalData = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getVirtualCode() {
        return virtualCode;
    }

    public void setVirtualCode(String virtualCode) {
        this.virtualCode = virtualCode;
    }

    public String getShortNum() {
        return shortNum;
    }

    public void setShortNum(String shortNum) {
        this.shortNum = shortNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalData() {
        return externalData;
    }

    public void setExternalData(String externalData) {
        this.externalData = externalData;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", title='" + title + '\'' +
                ", orgId=" + orgId +
                ", sequence=" + sequence +
                ", workPhone='" + workPhone + '\'' +
                ", shortNum='" + shortNum + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", externalId='" + externalId + '\'' +
                ", externalData='" + externalData + '\'' +
                "}\n";
    }
}
