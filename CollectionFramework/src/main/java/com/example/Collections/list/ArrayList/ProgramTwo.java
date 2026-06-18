package com.example.Collections.list.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramTwo {
    public static void main(String[] args) {
//        1 way to define list
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        List<String> list1 = Arrays.asList("Shubham", "Rathore");

//        2. another way to define list on the go but its only replace elements you cant add or remove or modify it too much
        System.out.println(list1.getClass().getName());
        System.out.println(list1);
        list1.set(1, "Sharma"); // take a look we can replace things

        System.out.println(list1);

        List<Integer>list3 =List.of(1,2,3,4,5);
        System.out.println(list3.getClass().getName());
//        list3.set(1,4); but here we can not replace things it will be immutable

//        Well sir you can do it but only after copying it to anthoer collection


    }

}
