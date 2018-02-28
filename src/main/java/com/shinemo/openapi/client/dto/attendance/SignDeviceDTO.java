package com.shinemo.openapi.client.dto.attendance;

/**
 * @author yuanjian
 * create 8/29/17
 * email liuyj@shinemo.com
 */
public class SignDeviceDTO {
    private String deviceId;
    private String deviceName;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
