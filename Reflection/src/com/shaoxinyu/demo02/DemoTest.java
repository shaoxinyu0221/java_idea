package com.shaoxinyu.demo02;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class DemoTest {

    public static void main(String[] args) {
        String className = getClassName("DemoClass.properties");
        try {
            Class<?> aClass = Class.forName(className);
            Method methodSay = aClass.getMethod("say");
            Object obj = aClass.newInstance();
            methodSay.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getClassName(String propertiesName){
        String className = null;
        Properties properties = new Properties();
        try(InputStream input = DemoTest.class.getClassLoader().getResourceAsStream(propertiesName);) {
            properties.load(input);
            className = properties.getProperty("className");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return className;
    }



}
