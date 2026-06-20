package com.example.Collections.map.hashmap.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProgramOne {
    public static void main(String[] args) {
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "Shubham");
        mp.put(2, "Aayush");
        mp.put(3, "girdhar");
        mp.put(3, "Anas");

        System.out.println(mp.containsKey(2));
        System.out.println(mp.containsValue("Anas"));

        for (int i : mp.keySet()) {
            System.out.println(mp.get(i));
        }

        Set<Map.Entry<Integer, String>> st = mp.entrySet();
        for (Map.Entry<Integer, String> entry : st) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
