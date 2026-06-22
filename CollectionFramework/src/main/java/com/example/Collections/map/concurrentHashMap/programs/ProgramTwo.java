package com.example.Collections.map.concurrentHashMap.programs;

import java.util.concurrent.ConcurrentHashMap;

public class ProgramTwo {
    public static void main(String [] args){
        ConcurrentHashMap<Integer,String> chp = new ConcurrentHashMap<>();
        // java 7 --> segment based locking --> 16 segments --> smaller hashmaps
        // only the segment written to or read will be locked
        //read --> don't require locking unless there is a write operation happening in the same segment
        //write --> lock

        //java 8 --> no segmentation
         // compare and swap method  --> no lock except resizing or collision
        //Thread A last saw --> x = 45
        // Thread A work -> to make it 50
        //if x is stil 45 then change it to 50 else don't change and retry
        //put --> index
    }
}
