package com.dz.entity;

import com.dz.annotation.TableName;

@TableName()
public class NewsUser {
    private Integer id; //用户id
    private String userName;//用户账号
    private String password;//用户密码
    private String email;//用户邮箱
    private Integer userType;//用户类型

    public NewsUser() {
    }

    public NewsUser(Integer id, String userName, String password, String email, Integer userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "NewsUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}
