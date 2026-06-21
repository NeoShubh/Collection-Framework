package com.example.Collections.map.identityHashMap.programs;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class ProgramOne {
    public static void main(String [] args){
        String s1 = new String("Key1");
        String s2 = new String("Key1");
//        HashMap<String,Integer> mp = new HashMap<>();
        IdentityHashMap<String,Integer> mp = new IdentityHashMap<>();
        mp.put(s1,1);
        mp.put(s2,2);
        System.out.println(mp);
    }
}
