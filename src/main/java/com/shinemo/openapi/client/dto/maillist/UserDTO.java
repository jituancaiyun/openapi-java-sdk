package com.shinemo.openapi.client.dto.maillist;

/**
 * Created by yuanjian on 6/12/17.
 */
public class UserDTO {
    private String uid;
    private String userName;
    private String mobile;
    private Long id;
    private Integer isAdmin;
    private Long deptId;
    private Long oldDeptId;
    private String title;
    private Long orgId;
    private Integer sequence;
    private String workPhone;
    private String externalId = "";
    private String externalData = "";
    private String privilege = "";

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getOldDeptId() {
        return oldDeptId;
    }

    public void setOldDeptId(Long oldDeptId) {
        this.oldDeptId = oldDeptId;
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

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", id=" + id +
                ", isAdmin=" + isAdmin +
                ", deptId=" + deptId +
                ", oldDeptId=" + oldDeptId +
                ", title='" + title + '\'' +
                ", orgId=" + orgId +
                ", sequence=" + sequence +
                ", workPhone='" + workPhone + '\'' +
                ", externalId='" + externalId + '\'' +
                ", externalData='" + externalData + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
