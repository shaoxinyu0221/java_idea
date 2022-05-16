package com.homework.home01;

public class DemoClass {

    private String name;
    private Integer age;
    private Double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public DemoClass(String name, Integer age, Double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public DemoClass() {
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
