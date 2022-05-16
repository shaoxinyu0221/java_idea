package com.shaoxinyu.demo04;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        //向Integer泛型的集合中添加String类型的数据
        List<Integer> list = new ArrayList<>();

        list.add(111);
        list.add(222);
        list.add(333);
        //通过反射绕过编译
        Class<? extends List> listClass = list.getClass();
        try {
            Method addMethod = listClass.getMethod("add", Object.class);
            addMethod.invoke(list, "111111");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
