package com.example.Collections.map.immutableMap.programs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProgramOne {
    public static void main(String[] args) {
//        A map which can not be modified one instantiated is called immutable map
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1,"Shubham");map1.put(2,"Shubham3");map1.put(3,"Shubham2");
        Map<Integer,String> map2 = Collections.unmodifiableMap(map1); // one way to create immutable map
        System.out.println(map2);
//      map2.put(4,"Shubh4"); //Exception in thread "main" java.lang.UnsupportedOperationException
        //can not contain the duplicate keys
        Map<String,Integer> map3= Map.of("Shubham1",5,"Shubham2",5,"Shubham3",5,"Shubham4",5,"Shubham5",5,"Shubham6",5,"Shubham7",5,"Shubham8",5,"Shubham9",5,"Shubham0",5); //but it only cantains 10 keys
        System.out.println(map3);
       Map<String,Integer> map4=  Map.ofEntries(Map.entry("keshav",5),Map.entry("Dhiraj",6));
        System.out.println(map4);
    }
}
