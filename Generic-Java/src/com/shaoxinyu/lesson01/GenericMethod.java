package com.shaoxinyu.lesson01;

import java.io.Serializable;

public class GenericMethod {

    public static <T> T change(Object element){
        return (T)element;
    }

    //定义一个方法,将任意类型的数组中的所有元素填充为相应类型的某个对象
    public static <T> T[] fun(T[] arr, T obj){
        for (int i=0;i<arr.length;i++){
            arr[i] = obj;
        }
        return arr;
    }



    public static void main(String[] args) {
//        Object str1 = "123";
//        String change = change(str1);
//        System.out.println(change);

        Integer[] arr = new Integer[5];


    }

}
