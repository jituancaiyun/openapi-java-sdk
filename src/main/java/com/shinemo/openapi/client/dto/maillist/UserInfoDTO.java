package com.shinemo.openapi.client.dto.maillist;

import java.util.ArrayList;

/**
 * Created by yuanjian on 6/12/17.
 */
public class UserInfoDTO {
    private String id;
    private String uid;
    private String name;
    private String userName;
    private String mobile;
    private String title;
    private Long orgId;
    private Integer sequence;
    private Integer isAdmin;
    private String workPhone;
    private String virtualCode;
    private String shortNum;
    private String email;
    private String fax;
    private Long deptId;
    private String externalId;
    private String externalData;
    private String privilege;
    private String jobCode;
    private String loginId;
    private String deptName;
    private ArrayList<Long> allDeptIds;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
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

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public ArrayList<Long> getAllDeptIds() {
        return allDeptIds;
    }

    public void setAllDeptIds(ArrayList<Long> allDeptIds) {
        this.allDeptIds = allDeptIds;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", title='" + title + '\'' +
                ", orgId=" + orgId +
                ", sequence=" + sequence +
                ", isAdmin=" + isAdmin +
                ", workPhone='" + workPhone + '\'' +
                ", virtualCode='" + virtualCode + '\'' +
                ", shortNum='" + shortNum + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", deptId=" + deptId +
                ", externalId='" + externalId + '\'' +
                ", externalData='" + externalData + '\'' +
                ", privilege='" + privilege + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", loginId='" + loginId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", allDeptIds=" + allDeptIds +
                '}';
    }
}
