package com.entity.model;

import java.io.Serializable;

public class ReportModel implements Serializable  {
    private static final long serialVersionUID = 1L;

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

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String reportType) {
        ReportType = reportType;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        Classification = classification;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    /**
     * ID
     */
    private long UserID;

    /**
     * 姓名
     */
    private String Name;

    /**
     * 类型
     */
    private String ReportType;

    /**
     * 分类
     */
    private String Classification;

    /**
     * 时间
     */
    private String DateTime;

    /**
     * 地点
     */
    private String Location;

    /**
     * 纬度
     */
    private String Latitude;

    /**
     * 经度
     */
    private String Longitude;

    /**
     * 手机
     */
    private String Phone;

    /**
     * 描述
     */
    private String Description;

    /**
     * 照片
     */
    private String Photo;

}

