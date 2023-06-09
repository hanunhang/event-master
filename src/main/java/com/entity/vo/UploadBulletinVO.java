package com.entity.vo;

import java.io.Serializable;

public class UploadBulletinVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 公告主键
     */
    private long announcement_id;

    /**
     * 纬度
     */
    private String announcement_latitude;

    /**
     * 经度
     */
    private String announcement_longitude;

    /**
     * 描述
     */
    private String announcement_description;

    /**
     * 照片
     */
    private String announcement_photo;

    /**
     * 时间
     */
    private String announcement_date;

    public long getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(long announcement_id) {
        this.announcement_id = announcement_id;
    }

    public String getAnnouncement_latitude() {
        return announcement_latitude;
    }

    public void setAnnouncement_latitude(String announcement_latitude) {
        this.announcement_latitude = announcement_latitude;
    }

    public String getAnnouncement_longitude() {
        return announcement_longitude;
    }

    public void setAnnouncement_longitude(String announcement_longitude) {
        this.announcement_longitude = announcement_longitude;
    }

    public String getAnnouncement_description() {
        return announcement_description;
    }

    public void setAnnouncement_description(String announcement_description) {
        this.announcement_description = announcement_description;
    }

    public String getAnnouncement_photo() {
        return announcement_photo;
    }

    public void setAnnouncement_photo(String announcement_photo) {
        this.announcement_photo = announcement_photo;
    }

    public String getAnnouncement_date() {
        return announcement_date;
    }

    public void setAnnouncement_date(String announcement_date) {
        this.announcement_date = announcement_date;
    }
}
