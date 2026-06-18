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

        List<Integer> list3 = List.of(6, 7, 8, 9);

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

//        we can convert it to array
    list.toArray();
    }
}
