package com.shaoxinyu.entity;

public class Book {

    private Integer id;
    private String bookName;
    private String bookDesp;
    private String bokPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesp() {
        return bookDesp;
    }

    public void setBookDesp(String bookDesp) {
        this.bookDesp = bookDesp;
    }

    public String getBokPrice() {
        return bokPrice;
    }

    public void setBokPrice(String bokPrice) {
        this.bokPrice = bokPrice;
    }

    public Book(Integer id, String bookName, String bookDesp, String bokPrice) {
        this.id = id;
        this.bookName = bookName;
        this.bookDesp = bookDesp;
        this.bokPrice = bokPrice;
    }

    public Book(String bookName, String bookDesp, String bokPrice) {
        this.bookName = bookName;
        this.bookDesp = bookDesp;
        this.bokPrice = bokPrice;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookDesp='" + bookDesp + '\'' +
                ", bokPrice='" + bokPrice + '\'' +
                '}';
    }
}
