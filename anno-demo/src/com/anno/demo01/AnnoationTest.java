package com.anno.demo01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnoationTest {

    public static void main(String[] args) {
        Class<Person> aClass = Person.class;

        try {
            //获取方法
            Method method1 = aClass.getMethod("empty");

            Method method2 = aClass.getDeclaredMethod("somebody", String.class, int.class);

            //调用方法
            method1.invoke(aClass.newInstance());
            method2.invoke(aClass.newInstance(),"小黄",18);


            //获取方法上的注解
            if (method1.isAnnotationPresent(MyAnnoation.class)) {
                MyAnnoation annotation = method1.getAnnotation(MyAnnoation.class);
                System.out.println(Arrays.toString(annotation.value()));
            }
            Person person = aClass.newInstance();
            if (method2.isAnnotationPresent(MyAnnoation.class)) {
                MyAnnoation annotation = method2.getAnnotation(MyAnnoation.class);
                System.out.println(Arrays.toString(annotation.value()));
                Field field = aClass.getDeclaredField("name");
                field.set(person,annotation.value()[0]);
                System.out.println(field.get(person));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
