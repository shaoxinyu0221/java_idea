package com.shaoxinyu.demo01;

/**
 * @author Administrator
 */
public class Animal {

    private String name;
    private Integer age;

    public void eat(String food){
        System.out.println(food + "好吃");
    }

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

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
