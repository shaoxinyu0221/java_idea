package com.shaoxinyu.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TsetGeneric<T extends List<String>> {

    public void listSort(T t){
        Comparator com = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {

                return 0;
            }
        };

    }

}

class Test01{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("fdaf");
        list.add("bfddf");
        list.add("dgr");
        list.add("fseff");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}