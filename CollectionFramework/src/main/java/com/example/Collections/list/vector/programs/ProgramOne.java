package com.example.Collections.list.vector.programs;

import java.util.LinkedList;
import java.util.Vector;

//Arraylist vs vector
//Hear my story lets say you have a arraylist and then created two threads in each thread
//you are having a loop till 1000 and each iteration is adding one element in arralist
//two loops -> thousand time addition -> two times -> it should become 2000 but it will not
//here both threads tries to access the arraylist tries to add the element and increment the size
//both sometimes cant make it sometimes they that is why vector here use synchorized so that one
//thread can lock the resource while other waits for other

public class ProgramOne {
    public static void main(String[] args) {
//unlike arraylist vector doubles its capacity when it reaches the size
        Vector<Integer> v1 = new Vector<>(10, 3);
        v1.add(1);
        v1.add(76);
        v1.add(5);
        v1.add(11);
        v1.add(23);
        v1.add(4);
        v1.add(23);
        v1.add(4);

        v1.add(23);
        v1.add(4);
        System.out.println(v1.capacity());
        v1.add(23);
        v1.add(4);
        System.out.println(v1.capacity());
        v1.add(4);
        v1.add(4);
        v1.add(4);
        v1.add(4);
        System.out.println(v1.capacity());

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(17);
        l1.add(22);
        l1.add(42);
        l1.add(13);
        Vector<Integer> v2 = new Vector<>(l1);
        System.out.println(v2);
    }
}
