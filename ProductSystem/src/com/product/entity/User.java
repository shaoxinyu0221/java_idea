package com.product.entity;

import java.util.List;

public class User {
    private Integer id;
    private String username;
    private Integer age;
    private Double money;
    private List<Cart> cartList;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User(Integer id, String username, Integer age, Double money, List<Cart> cartList) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.money = money;
        this.cartList = cartList;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", cartList=" + cartList +
                '}';
    }
}
