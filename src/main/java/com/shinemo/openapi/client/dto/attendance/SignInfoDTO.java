package com.shinemo.openapi.client.dto.attendance;

/**
 * @author yuanjian
 * create 8/29/17
 * email liuyj@shinemo.com
 */
public class SignInfoDTO {
    private boolean isRest;
    private int signStatus;
    private int dutyType;
    private int signType;
    private String settingName;
    private String uid;
    private String externalId;
    private String signTime;
    private String createTime;
    private String modTime;
    private String extData;
    private String baseSignTime;
    private String dutyName;
    private SignDeviceDTO signDeviceDTO;
    private String signDay;

    public boolean isRest() {
        return isRest;
    }

    public void setRest(boolean rest) {
        isRest = rest;
    }

    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    public int getDutyType() {
        return dutyType;
    }

    public void setDutyType(int dutyType) {
        this.dutyType = dutyType;
    }

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    public String getBaseSignTime() {
        return baseSignTime;
    }

    public void setBaseSignTime(String baseSignTime) {
        this.baseSignTime = baseSignTime;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public SignDeviceDTO getSignDeviceDTO() {
        return signDeviceDTO;
    }

    public void setSignDeviceDTO(SignDeviceDTO signDeviceDTO) {
        this.signDeviceDTO = signDeviceDTO;
    }

    public String getSignDay() {
        return signDay;
    }

    public void setSignDay(String signDay) {
        this.signDay = signDay;
    }
}
