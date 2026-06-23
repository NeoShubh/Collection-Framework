package com.example.Collections.map.concurrentHashMap.programs;

import java.util.concurrent.ConcurrentHashMap;

public class ProgramThree {
    public static void main(String [] args){
        ConcurrentHashMap<Integer,String> mp = new ConcurrentHashMap<>();
        mp.put(1,"abc");
    }
}
