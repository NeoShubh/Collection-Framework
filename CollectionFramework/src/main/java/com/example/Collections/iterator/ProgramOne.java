package com.example.Collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgramOne {
    public static void main(String[] args) {

//        We will face error with this following case
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        for (Integer num : list) {
//            System.out.println(num);
//            if (num % 2 == 0)
//                list.remove(num); // Arraylist internally implements the iterator iterface that is why it allows us to iterate over array
//        }

        //this works just fine because we know the use cases of it
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer num : list) {
            System.out.println(num);
            if (num % 2 == 0)
                list.remove(num); // Arraylist internally implements the iterator iterface that is why it allows us to iterate over array
        }
        System.out.println(list);

        //but with iterators we get this functionlity to remove the elements
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        Iterator<Integer> itr = list1.iterator();
        while (itr.hasNext()) {
            Integer num = itr.next();

            if (num % 2 == 0)
                itr.remove(); // this is the way to remvove
        }
        System.out.println(list1);
    }
}
