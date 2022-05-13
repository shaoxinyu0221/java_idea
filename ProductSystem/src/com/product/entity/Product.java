package com.product.entity;

import java.util.List;

public class Product {

    private Integer id;
    private String pName;
    private Double pPrice;
    //private User user;
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public Product(Integer id, String pName, Double pPrice) {
        this.id = id;
        this.pName = pName;
        this.pPrice = pPrice;
    }

    public Product(Integer id, String pName, Double pPrice, List<User> userList) {
        this.id = id;
        this.pName = pName;
        this.pPrice = pPrice;
        this.userList = userList;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", userList=" + userList +
                '}';
    }
}
