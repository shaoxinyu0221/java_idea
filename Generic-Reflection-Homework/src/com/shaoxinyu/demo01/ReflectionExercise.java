package com.shaoxinyu.demo01;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
    //animalClass
    @Test
    public void getAllFiles(){
        Class<?> animalClass = null;
        try {
            animalClass = Class.forName("com.shaoxinyu.demo01.Animal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取所有public成员变量,包括继承的
        Field[] fields = animalClass.getFields();
        //获取所有本类中的成员变量,包括private
        Field[] declaredFields = animalClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            System.out.println(declaredField.getName() + " " +declaredField.getType().getSimpleName());
        }
        System.out.println("===========================");
        //获取单个属性
        try {
            Field name = animalClass.getDeclaredField("name");
            //创建对象,为对象的name属性赋值
            //如果在获取Class类类型对象的时候,已经通过泛型制定了明确的class,通过newInstance创建的对象可以直接调方法
            //Animal animal = animalClass.newInstance();

            Object dog = animalClass.newInstance();
            //setFieldFun("name", dog, "大黄");

            //因为变量时private的,所以要通过set和get方法访问
            //获取get和set方法
            //1.设置方法名

            String setName = "set" + name.getName().substring(0,1).toUpperCase() + name.getName().substring(1);
            String getName = "get" + name.getName().substring(0,1).toUpperCase() + name.getName().substring(1);

            //2.通过方法名获取方法
            Method setNameMethod = animalClass.getDeclaredMethod(setName, name.getType());
            Method getNameMethod = animalClass.getDeclaredMethod(getName);

            //3.调方法
            setNameMethod.invoke(dog, "大黄");
            Object dogName = getNameMethod.invoke(dog);

            System.out.println("dog的名字是" + dogName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAllConstructors(){
        Class<Animal> animalClass = Animal.class;
        Constructor<?>[] constructors = animalClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            System.out.print(constructor + "\t");
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                System.out.print(parameterType.getSimpleName());
            }
            System.out.println("");
        }
    }

    //动态获取get/set方法
    public static <T> void setFieldFun(String className, String fieldName, Object obj, T parameter){
        try {
            //1.获取Class
            //Class<?> aClass = Animal.class;
            Class<?> aClass = Class.forName(className);
            //2.获取类的属性名
            Field field = aClass.getDeclaredField(fieldName);
            //创建get方法
            String setField = "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
            //创建get方法
            String getField = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
            //获取方法
            Method methodSet = aClass.getMethod(setField, field.getType());
            Method methodGet = aClass.getMethod(getField);
            //调方法
            Object invoke = methodSet.invoke(obj, parameter);
            Object invoke1 = methodGet.invoke(obj);
            System.out.println(invoke1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static <T> void getFieldFun(String className, String fieldName, Object obj){
//        Object invoke = null;
//        try {
//            //1.获取Class
//            //Class<?> aClass = Animal.class;
//            Class<?> aClass = Class.forName(className);
//            //2.获取类的属性名
//            Field field = aClass.getDeclaredField(fieldName);
//            //创建get方法
//            String getField = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
//            //获取方法
//            Method method = aClass.getMethod(getField);
//            //调方法
//            invoke = method.invoke(obj);
//            System.out.println(invoke);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}

class dog{
    public static void main(String[] args) {
        Animal dog = new Animal();
        ReflectionExercise.setFieldFun("com.shaoxinyu.demo01.Animal","name",dog,"大黄");

    }
}