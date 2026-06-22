package com.example.Collections.map.concurrentHashMap.programs;

import java.util.Hashtable;

public class programOne {
    public static void main(String[] args) {
        Hashtable<String, Integer> hmp = new Hashtable<>();
        //hashtable is synchronized
        //no null key or value
        //legacy class --> concurrentHashMap
        //slower than hashmap
        //only linked list in case of collision
        //All methods are synchronized
        hmp.put("Shubham", 1);
        hmp.put("Mohit", 2);
        hmp.put("Rashi", 3);
        System.out.println(hmp);

//        HashMap<Integer, String> mp = new HashMap<>();
        Hashtable<Integer, String> mp = new Hashtable<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                mp.put(i, "THread1");
            }

        });
        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                mp.put(i, "THread2");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("size of mp " + mp.size());
    }
}
