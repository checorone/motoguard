package com.oneorg.devices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @Column(name = "device_id", nullable = false)
    String id;

    @Column(name = "type", nullable = false)
    String type;

    @Column(name = "owner_username", nullable = false)
    String owner;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceType() {
        return type;
    }

    public void setDeviceType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
