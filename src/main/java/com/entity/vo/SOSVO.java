package com.entity.vo;

import java.io.Serializable;

public class SOSVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private long UserID;

    /**
     * 姓名
     */
    private String Name;

    /**
     * age
     */
    private long Age;

    /**
     * sex
     */
    private String Gender;

    /**
     * Phone
     */
    private String Phone;

    /**
     * address
     */
    private String User_address;

    /**
     * email
     */
    private String User_email;

    /**
     * 紧急联系方式
     */
    private String Emergency_email1;

    /**
     * 紧急联系方式2
     */
    private String Emergency_email2;

    /**
     * 照片
     */
    private String User_photo;

    /**
     * 用户号
     */
    private String User_Number;

    /**
     * 密码
     */
    private String User_password;

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

    public long getAge() {
        return Age;
    }

    public void setAge(long age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getUser_address() {
        return User_address;
    }

    public void setUser_address(String user_address) {
        User_address = user_address;
    }

    public String getUser_email() {
        return User_email;
    }

    public void setUser_email(String user_email) {
        User_email = user_email;
    }

    public String getEmergency_email1() {
        return Emergency_email1;
    }

    public void setEmergency_email1(String emergency_email1) {
        Emergency_email1 = emergency_email1;
    }

    public String getEmergency_email2() {
        return Emergency_email2;
    }

    public void setEmergency_email2(String emergency_email2) {
        Emergency_email2 = emergency_email2;
    }

    public String getUser_photo() {
        return User_photo;
    }

    public void setUser_photo(String user_photo) {
        User_photo = user_photo;
    }

    public String getUser_Number() {
        return User_Number;
    }

    public void setUser_Number(String user_Number) {
        User_Number = user_Number;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }
}
