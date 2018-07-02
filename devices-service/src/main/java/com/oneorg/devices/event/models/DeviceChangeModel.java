package com.oneorg.devices.event.models;

public class DeviceChangeModel{
    private String type;
    private String action;
    private String deviceId;
    private String correlationId;


    public  DeviceChangeModel(String type, String action, String deviceId, String correlationId) {
        super();
        this.type   = type;
        this.action = action;
        this.deviceId = deviceId;
        this.correlationId = correlationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }


}