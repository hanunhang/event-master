package com.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 报告
 * 数据库通用操作实体类（普通增删改查）

 */
@TableName("reportforsafety")
public class ReportEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    *主键
    */
    @TableId
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

    @Override
    public String toString() {
        return "ReportEntity{" +
                "UserID=" + UserID +
                ", Name='" + Name + '\'' +
                ", ReportType='" + ReportType + '\'' +
                ", Classification='" + Classification + '\'' +
                ", DateTime='" + DateTime + '\'' +
                ", location='" + location + '\'' +
                ", Latitude='" + Latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Description='" + Description + '\'' +
                ", Photo='" + Photo + '\'' +
                '}';
    }

    /**
     * 时间
     */
    private String DateTime;

    /**
     * 地点
     */
    private String location;

    /**
     * 纬度
     */
    private String Latitude;

    /**
     * 经度
     */
    private String Longitude;

    /**
     * 电话
     */
    private String Phone;

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
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
     * 描述
     */
    private String Description;

    /**
     * 照片
     */
    private String Photo;

}
