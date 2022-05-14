package com.shaoxinyu.lesson01;

public class MyArraysList {

    public static void main(String[] args) {
        GenericList<String> genericList = new GenericList<>();
        StringBuffer string = genericList.listToString(new Integer[]{1, 2, 3, 4});
        System.out.println(string);
    }

}

class GenericList<T> {

    public static <E> E fun(E e){
        return e;
    }

    public StringBuffer listToString(Integer[] arr){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            if(i==0){
                buffer.append("[" + arr[i] + ",");
            }else if(i==arr.length-1){
                buffer.append(arr[arr.length-1] + "]");
            }else {
                buffer.append(arr[i] + ",");
            }
        }
        return buffer;
    }

}
