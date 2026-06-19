package com.example.Collections.list.LinkedList.programs;

import java.util.LinkedList;

public class ProgramOne {
    public static void main(String [] args){
        LinkedList <Integer> list = new LinkedList<>();
        list.add(1);list.add(2);list.add(4);list.add(3);list.add(5);
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.addFirst(9);list.addLast(10);
        System.out.println(list);
        list.removeIf(x->x%2==0);
        System.out.println(list);

    }
}
