package com.example.Collections.set;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadSafeSet {
    public static void main(String[] args) {
//If the read intersive things are there we must use copy write arrayset because if write happns
//                each time a new copy will be created for it
//and if frequent read and write are there then we will use concurrentSkiplistset
        
//        we can also give unmodified or immutable set
        Set<Integer> st1 = Set.of(12, 3, 2, 5, 4, 6);
        System.out.println(st1);

        //Thread safe
        Set<Integer> st2 = new ConcurrentSkipListSet<>();
        Set<Integer> st3 = new CopyOnWriteArraySet<>(); //it creates a seperate copy of array to read and one to write
        for (int i = 0; i <= 5; i++) {
            st2.add(i);
            st3.add(i);
        }
        System.out.println(st2);
        System.out.println(st3);
        //strongly consistent
        for(Integer x : st2){
            System.out.println(x);
            st2.add(6);
        }
        System.out.println(st2);

        //here when you try to add a new number it will not print it but after loop it does
        //weakly consistent
        for(Integer x : st3){
            System.out.println(x);
            st3.add(6);
        }
        System.out.println(st3);
    }
}
