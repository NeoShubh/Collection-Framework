package com.example.Collections.map.sortedMap.programs;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class ProgramOne {
    public static void main(String [] args){
        SortedMap<String,Integer> smp = new TreeMap<>();
        smp.put("Shubham",21);
        smp.put("Vikas",12);
        smp.put("Varsha",63);
        System.out.println(smp);
        System.out.println(smp.firstKey());
        System.out.println(smp.lastKey());
        System.out.println(smp.headMap("Varsha"));
        System.out.println(smp.tailMap("Vikas"));

        NavigableMap<Integer,String> nmp = new TreeMap<>();
        nmp.put(11,"HP");
        nmp.put(70,"Dell");
        nmp.put(1,"Intel");
        nmp.put(20,"EDE");
        System.out.println(nmp);
        System.out.println(nmp.lowerKey(12));
        System.out.println(nmp.ceilingKey(20));
        System.out.println(nmp.higherKey(1));
    }
}
