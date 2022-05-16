package com.homework.home01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Demo01 {


    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();
        setProperty(demoClass,"name", "大黄");
        System.out.println(demoClass.getName());
    }


    /**
     * 将对象obj中名为propertyName的属性设置为value
     * @param obj 要修改的对象
     * @param propertyName 要修改的属性名
     * @param value 修改后的值
     */
    public static void setProperty(Object obj, String propertyName, Object value){
        //获取Class类
        Class<?> aClass = obj.getClass();
        try {
            //查找obj中对应名字的属性
            Field field = aClass.getDeclaredField(propertyName);
            //写set方法名
            String setField = "set"+field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
            //查询obj中相对应的方法
            Method declaredMethodSet = aClass.getDeclaredMethod(setField, field.getType());
            declaredMethodSet.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
