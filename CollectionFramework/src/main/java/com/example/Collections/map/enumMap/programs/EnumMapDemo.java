package com.example.Collections.map.enumMap.programs;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        //it maintains a array with index with the size of enum
        // it simply create a array of day class and when needs to put value it simply assign it
        //order will be same as the appearance of the key in the enum class
        //no hashing is implemented in enum class it requires ordinal/index
        Map<Day,Integer> mp = new EnumMap<>(Day.class);
        mp.put(Day.SUNDAY,4);
        mp.put(Day.TUESDAY,2);
        System.out.println(mp);

    }
}

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}