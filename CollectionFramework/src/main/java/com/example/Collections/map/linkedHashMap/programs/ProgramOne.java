package com.example.Collections.map.linkedHashMap.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProgramOne {
    public
    static void main(String [] args){
        LinkedHashMap <String,Integer> list = new LinkedHashMap<>(12,2.5f,true);
        //Linked hash map use doubly linked list to keep up the order
        //access order put the least used product at the top
        list.put("Oranges",12);
        list.put("Apples",11);
        list.put("grapes",13);
        list.put("peaches",10);
        list.get("peaches");
        list.get("grapes");
        list.get("Apples");
        for(Map.Entry<String,Integer> entry : list.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
