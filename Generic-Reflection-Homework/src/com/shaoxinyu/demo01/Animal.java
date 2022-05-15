package com.shaoxinyu.demo01;

public class Animal {

    private String name;
    private Integer age;

    public void eat(String food){
        System.out.println("吃"+food);
        System.out.println("eat方法被调用了");
    }

    private void drink(){
        System.out.println("drink方法被调用了");
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
