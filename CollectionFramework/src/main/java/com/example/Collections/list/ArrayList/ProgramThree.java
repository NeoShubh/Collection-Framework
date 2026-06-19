package com.example.Collections.list.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ProgramThree {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> list3 = List.of(6, 7, 8, 9,0);

        list.addAll(list3);
        System.out.println(list);
        ArrayList<String> alpha = new ArrayList<>();
        alpha.add("a");
        alpha.add("a");
        alpha.add("a");
        alpha.add("a");
        alpha.remove("a");
        System.out.println(alpha); // it will remvoe hte alpha present only the first occurance

        System.out.println(list);//now we will see thing we wanted

        list.remove(1); // it will remove the indexed element to make it work list string we must wrap it up
        System.out.println(list);//now we will see thing we wanted

        list.remove(Integer.valueOf(1));
        System.out.println(list);//now we will see thing we wanted

        System.out.println(alpha.contains("a"));
//        we can convert it to array
        Object[] objlist = list.toArray();
        System.out.println(objlist);
        Integer[] integerArr = list.toArray(new Integer[0]);// its one way to convert list into integer array if we dont write new Integer then java assumes it as object array
        System.out.println(integerArr);

        list.sort(null); //comparater padhenge program four main
        System.out.println(list);
    }
}
