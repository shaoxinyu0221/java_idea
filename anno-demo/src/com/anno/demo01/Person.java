package com.anno.demo01;

public class Person {

    String  name;

    @MyAnnoation
    public void empty(){
        System.out.println("empty方法被调用了");
    }

    @MyAnnoation({"boy","girl"})
    public void somebody(String name, int age){
        System.out.println("somebody方法被调用了,name=" + name + ",aget=" + age);
    }
}
