package com.anno.demo03;

import com.anno.demo03.Table;

@Table("CUSTOMER")
public class Customer {
    //id,name,gender,age,birthday
    @Id(value="id",autoIncrement=true)
    private Integer id;
    @column(value="name",columnType = "varchar(10)")
    private String name;
    @column(value="name",columnType = "varchar(5)")
    private String gender;
    @column(value="name",columnType = "int")
    private Integer age;
    @column(value="name",columnType = "date")
    private String birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
