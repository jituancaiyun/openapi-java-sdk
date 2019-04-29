package com.shinemo.openapi.client.dto.contact;

/**
 * 通讯录导入-用户
 *
 * @author yuanjian
 * date 1/22/18
 * email liuyj@shinemo.com
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
    private Integer sequence;
    private String jobCode;
    private Integer status;
    private String loginId;
    private String privilege;
    private Integer type;
    private String mobile2;
    private Integer employeeState;
    private Integer employeeType;
    private String shortNum2;
    private String workPhone2;
    private String customField;
    private String entryTime;
    private String firstWorkTime;
    private String positiveTime;

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public Integer getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(Integer employeeState) {
        this.employeeState = employeeState;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public String getShortNum2() {
        return shortNum2;
    }

    public void setShortNum2(String shortNum2) {
        this.shortNum2 = shortNum2;
    }

    public String getWorkPhone2() {
        return workPhone2;
    }

    public void setWorkPhone2(String workPhone2) {
        this.workPhone2 = workPhone2;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getFirstWorkTime() {
        return firstWorkTime;
    }

    public void setFirstWorkTime(String firstWorkTime) {
        this.firstWorkTime = firstWorkTime;
    }

    public String getPositiveTime() {
        return positiveTime;
    }

    public void setPositiveTime(String positiveTime) {
        this.positiveTime = positiveTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"mobile\":\"")
                .append(mobile).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"workPhone\":\"")
                .append(workPhone).append('\"');
        sb.append(",\"shortNum\":\"")
                .append(shortNum).append('\"');
        sb.append(",\"virtualCode\":\"")
                .append(virtualCode).append('\"');
        sb.append(",\"virtualCellPhone\":\"")
                .append(virtualCellPhone).append('\"');
        sb.append(",\"fax\":\"")
                .append(fax).append('\"');
        sb.append(",\"deptId\":\"")
                .append(deptId).append('\"');
        sb.append(",\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"externalData\":\"")
                .append(externalData).append('\"');
        sb.append(",\"sequence\":")
                .append(sequence);
        sb.append(",\"jobCode\":\"")
                .append(jobCode).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"loginId\":\"")
                .append(loginId).append('\"');
        sb.append(",\"privilege\":\"")
                .append(privilege).append('\"');
        sb.append(",\"type\":")
                .append(type);
        sb.append(",\"mobile2\":\"")
                .append(mobile2).append('\"');
        sb.append(",\"employeeState\":")
                .append(employeeState);
        sb.append(",\"employeeType\":")
                .append(employeeType);
        sb.append(",\"shortNum2\":\"")
                .append(shortNum2).append('\"');
        sb.append(",\"workPhone2\":\"")
                .append(workPhone2).append('\"');
        sb.append(",\"customField\":\"")
                .append(customField).append('\"');
        sb.append(",\"entryTime\":\"")
                .append(entryTime).append('\"');
        sb.append(",\"firstWorkTime\":\"")
                .append(firstWorkTime).append('\"');
        sb.append(",\"positiveTime\":\"")
                .append(positiveTime).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
