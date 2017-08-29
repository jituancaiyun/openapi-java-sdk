package com.shinemo.openapi.client.dto.attendance;

/**
 * @auther yuanjian
 * @create 8/29/17
 * @email liuyj@shinemo.com
 */
public class ImportSignInfoDTO {
    private int signType;
    private String signTime;
    private String uid;
    private String externalId;
    private String extData;
    private SignDeviceDTO dev;

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
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

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    public SignDeviceDTO getDev() {
        return dev;
    }

    public void setDev(SignDeviceDTO dev) {
        this.dev = dev;
    }
}
