package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 请求sos
 * 数据库通用操作实体类（普通增删改查）

 */
@TableName("sos")
public class CallSOSEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id主键
     */
    @TableId
    private long UserID;

    /**
     * 姓名
     */
    private String Name;

    /**
     * 纬度
     */
    private String SOSLatitude;

    /**
     * 经度
     */
    private String SOSLongitude;

    /**
     * 位置
     */
    private String CurrentLocation;

    @Override
    public String toString() {
        return "CallSOSEntity{" +
                "UserID=" + UserID +
                ", Name='" + Name + '\'' +
                ", SOSLatitude='" + SOSLatitude + '\'' +
                ", SOSLongitude='" + SOSLongitude + '\'' +
                ", CurrentLocation='" + CurrentLocation + '\'' +
                '}';
    }

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSOSLatitude() {
        return SOSLatitude;
    }

    public void setSOSLatitude(String SOSLatitude) {
        this.SOSLatitude = SOSLatitude;
    }

    public String getSOSLongitude() {
        return SOSLongitude;
    }

    public void setSOSLongitude(String SOSLongitude) {
        this.SOSLongitude = SOSLongitude;
    }

    public String getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        CurrentLocation = currentLocation;
    }
}
