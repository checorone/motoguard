package com.oneorg.rawdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "rawdata")
public class Data{
  @Id
  @Column(name = "device_id", nullable = false)
  private String deviceId;

  @Column(name = "message_id", nullable = false)
  private String messageId;

  @Column(name = "latitude", nullable = false)
  private float latitude;

  @Column(name = "longitude", nullable = false)
  private float longitude;

  @Column(name = "speed", nullable = false)
  private float speed;

  @Column(name = "dop", nullable = false)
  private float dop;

  @Column(name = "vibration", nullable = false)
  private float vibration;

  @Column(name = "gx", nullable = false)
  private float gx;

  @Column(name = "gy", nullable = false)
  private float gy;

  @Column(name = "gz", nullable = false)
  private float gz;

  @Column(name = "degx", nullable = false)
  private float degx;

  @Column(name = "degy", nullable = false)
  private float degy;

  @Column(name = "degz", nullable = false)
  private float degz;

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public float getDop() {
    return dop;
  }

  public void setDop(float dop) {
    this.dop = dop;
  }

  public float getVibration() {
    return vibration;
  }

  public void setVibration(float vibration) {
    this.vibration = vibration;
  }

  public float getGx() {
    return gx;
  }

  public void setGx(float gx) {
    this.gx = gx;
  }

  public float getGy() {
    return gy;
  }

  public void setGy(float gy) {
    this.gy = gy;
  }

  public float getGz() {
    return gz;
  }

  public void setGy(float gz) {
    this.gz = gz;
  }

  public float getDegx() {
    return degx;
  }

  public void setdegx(float degx) {
    this.degx = degx;
  }

  public float getDegy() {
    return degy;
  }

  public void setdegy(float degy) {
    this.degy = degy;
  }

  public float getDegz() {
    return degz;
  }

  public void setdegz(float degz) {
    this.degz = degz;
  }
}
