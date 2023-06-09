package com.entity.vo;

import java.io.Serializable;

public class ReportVO implements Serializable  {
    private static final long serialVersionUID = 1L;

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String reportType) {
        ReportType = reportType;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
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
     * 报告类型
     */
    private String ReportType;

    /**
     * ID
     */
    private Long UserID;

    /**
     * 姓名
     */
    private String Name;

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
     * 经度
     */
    private String Longitude;

    /**
     * 纬度
     */
    private String Latitude;

    /**
     * 电话
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
