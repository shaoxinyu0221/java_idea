package com.product.entity;

public class Cart {

    private Integer id;
    private Integer uId;
    private Integer pId;
    private Integer number;
    private Double allPrice;
    private String pName;
    private Double price;


    public Cart(Integer uId, Integer pId, Integer number, Double allPrice) {
        this.uId = uId;
        this.pId = pId;
        this.number = number;
        this.allPrice = allPrice;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Double allPrice) {
        this.allPrice = allPrice;
    }

    public Cart(Integer id, Integer uId, Integer pId, Integer number, Double allPrice, String pName, Double price) {
        this.id = id;
        this.uId = uId;
        this.pId = pId;
        this.number = number;
        this.allPrice = allPrice;
        this.pName = pName;
        this.price = price;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uId=" + uId +
                ", pId=" + pId +
                ", number=" + number +
                ", allPrice=" + allPrice +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                '}';
    }
}
