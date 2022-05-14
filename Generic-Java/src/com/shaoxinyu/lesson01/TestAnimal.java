package com.shaoxinyu.lesson01;

public class TestAnimal{
    public static void main(String[] args) {
        Animal<Dog> eat = eat();
        Dog eat1 = eat.eat();
    }


    interface Animal<T> {
        T eat();
    }

    static class Dog implements Animal<Dog>{

        @Override
        public Dog eat() {
            System.out.println("狗吃肉");
            return new Dog();
        }
    }

    public static Animal<Dog> eat(){
        return new Dog();
    }
}



