package com.example.Collections.set;

import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        //Set --> Hashset, LinkedHashSet, TreeSet, EnumSet
//        Hashset is unordered and can not have duplicates
        Set<Integer> st = new java.util.HashSet<>();
        st.add(1);
        st.add(4);
        st.add(4);
        st.add(98);
        st.add(10);
        System.out.println(st);
    }
}
