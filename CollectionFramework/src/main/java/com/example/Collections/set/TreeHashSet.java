package com.example.Collections.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeHashSet {
    public static void main(String[] args) {
//        TreeHashSet is used in case where we need to sort
        Set<Integer> st = new TreeSet<>();
        st.add(3);
        st.add(2);
        st.add(9);
        st.add(1);
        st.add(30);
        st.add(1);
        System.out.println(st);
    }
}
