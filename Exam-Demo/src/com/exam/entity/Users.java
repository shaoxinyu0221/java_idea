package com.exam.entity;

import java.util.List;

public class Users {

    private Integer id;
    private String username;
    private String sex;
    private String address;
    private Double money;
    private String birthday;
    private List<AccountInfo> infoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<AccountInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<AccountInfo> infoList) {
        this.infoList = infoList;
    }
}
