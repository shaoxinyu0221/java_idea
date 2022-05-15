package com.shaoxinyu.demo04;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class DemoTest04 {

    public static void main(String[] args) {
        Properties clazz = getClazz();
        String className = clazz.getProperty("className");
        System.out.println(className);
        try {
            Class<?> aClass = Class.forName(className);
            Method run = aClass.getDeclaredMethod("run");
            Object obj = aClass.newInstance();
            run.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static Properties getClazz(){
        Properties properties = new Properties();
        InputStream input = DemoTest04.class.getClassLoader().getResourceAsStream("DemoClass.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
