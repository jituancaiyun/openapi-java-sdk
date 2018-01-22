package com.shinemo.openapi.client.dto.contact;

/**
 * 通讯录导入-用户
 *
 * @author yuanjian
 * @date 1/22/18
 * @email liuyj@shinemo.com
 */
public class User {

    private String name;
    private String mobile;
    private String title;
    private String email;
    private String workPhone;
    private String shortNum;
    private String virtualCode;
    private String virtualCellPhone;
    private String fax;
    private String deptId;
    private String userId;
    private String externalData;
    private int sequence;
    private String jobCode;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getShortNum() {
        return shortNum;
    }

    public void setShortNum(String shortNum) {
        this.shortNum = shortNum;
    }

    public String getVirtualCode() {
        return virtualCode;
    }

    public void setVirtualCode(String virtualCode) {
        this.virtualCode = virtualCode;
    }

    public String getVirtualCellPhone() {
        return virtualCellPhone;
    }

    public void setVirtualCellPhone(String virtualCellPhone) {
        this.virtualCellPhone = virtualCellPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExternalData() {
        return externalData;
    }

    public void setExternalData(String externalData) {
        this.externalData = externalData;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", shortNum='" + shortNum + '\'' +
                ", virtualCode='" + virtualCode + '\'' +
                ", virtualCellPhone='" + virtualCellPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", deptId='" + deptId + '\'' +
                ", userId='" + userId + '\'' +
                ", externalData='" + externalData + '\'' +
                ", sequence_=" + sequence +
                ", jobCode='" + jobCode + '\'' +
                '}';
    }
}
