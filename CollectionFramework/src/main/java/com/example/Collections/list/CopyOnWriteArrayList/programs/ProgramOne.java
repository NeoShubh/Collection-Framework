package com.example.Collections.list.CopyOnWriteArrayList.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgramOne {
    public static void main(String [] args){
//        List<String> list = new ArrayList<>();
//        list.add("APPLE");
//        list.add("MONGO");
//        list.add("GRAPES");
//
//        for(String fruit : list){
//            System.out.println(fruit);
//            if(fruit.equals("MONGO")){
//                list.add("MILK");
//            }
//        }
//        System.out.println(list);

//        Exception in thread "main" java.util.ConcurrentModificationException
//        at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
//        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
//        at com.example.Collections.list.CopyOnWriteArrayList.programs.ProgramOne.main(ProgramOne.java:13)

        List<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("APPLE");
        list1.add("MONGO");
        list1.add("GRAPES");

        for(String fruit : list1){
            System.out.println(fruit);
            if(fruit.equals("MONGO")){
                list1.add("MILK");
            }
        }
        System.out.println(list1);

    }
}
