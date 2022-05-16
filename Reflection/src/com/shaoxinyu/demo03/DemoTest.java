package com.shaoxinyu.demo03;

import java.lang.reflect.Method;

public class DemoTest {

    public static void main(String[] args) {
        Demo demo = new Demo();
        Class<? extends Demo> aClass = demo.getClass();
        //Class<Integer> integerClass = Integer.class;
        try {
            Method say = aClass.getDeclaredMethod("say", String.class, int.class);
            //Demo demo1 = aClass.newInstance();
            Object invoke = say.invoke(demo,"1234", 1234);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
