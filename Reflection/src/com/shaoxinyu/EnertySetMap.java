package com.shaoxinyu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EnertySetMap {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("1", 123);
        hashMap.put("2", 234);
        hashMap.put("3", 345);
        hashMap.put("4", 456);

        for (Integer value : hashMap.values()) {
            System.out.println(value);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        

    }



}
