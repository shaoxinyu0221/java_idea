package com.shaoxinyu.demo01;

public class ReflectTest {

    public static void main(String[] args) {
        /**
         * 获取Class类的方式
         */
        //1.方式一,通过类的对象获取
        Animal animal = new Animal();
        Class<? extends Animal> c1 = animal.getClass();
        //2.方式二,直接通过类获取
        Class<Animal> c2 = Animal.class;
        //3.方式三,动态获取
        Class<?> c3 = null;
        try {
            c3 = Class.forName("com.shaoxinyu.demo01.Animal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1==c2);
        System.out.println(c2==c3);

    }
}
