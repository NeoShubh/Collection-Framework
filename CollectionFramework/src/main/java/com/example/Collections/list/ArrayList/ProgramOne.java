package com.example.Collections.list.ArrayList;

import java.util.ArrayList;

public class ProgramOne {
    public static void main(String [] args){

        //we can give initial capacity to remove the overhead if we already
        // know there will be 1000 elements going to add we can give the capacity
        ArrayList <Integer> list = new ArrayList<>(1000);
        System.out.println(list.size());
        ArrayList <Integer> list1 = new ArrayList<>(11);
        list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);
        list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);
        System.out.println(list1.size()); //the size is 12 but the capacity becomes 11 * 1.5 = 16.5 or ~16

    }
}
