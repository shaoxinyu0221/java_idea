package com.shaoxinyu.demo01;

import java.lang.reflect.Method;

public class ReflectionExercise {

    public static void main(String[] args) {
        //动态获取Class
        try {
            Class<?> aClass = Class.forName("com.shaoxinyu.demo01.Animal");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //获取Class类
        Class<?> animalClass = Animal.class;
        //获取类名
        String name = animalClass.getSimpleName();
        System.out.println(name);
        //获取方法名和返回值类型(本类方法,包括private方法)
        for (Method method : animalClass.getMethods()) {
            System.out.println(method.getName()+"\t"+method.getReturnType().getSimpleName()+"\t");
        }
        System.out.println("===============================================");
        //获取public方法列表(包括父类)
        Method[] methods = animalClass.getMethods();
        for (Method method : methods){
            //获取形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.print(method.getName()+"\t"+method.getReturnType().getSimpleName()+"\t");
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType);
            }
            System.out.println("");
        }

        System.out.println("===============================================");
        //获取方法
        try {
            Method eat = animalClass.getDeclaredMethod("eat", String.class);
            Object obj = animalClass.newInstance();
            //调方法
            eat.invoke(obj,"汉堡");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取私有方法
        try {
            Method drink = animalClass.getDeclaredMethod("drink");
            drink.setAccessible(true);
            drink.invoke(animalClass.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
