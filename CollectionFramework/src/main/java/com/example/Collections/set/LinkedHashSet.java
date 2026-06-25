package com.example.Collections.set;

import java.util.Set;

public class LinkedHashSet {
    public static void main(String[] args) {
//        linkedHashSet is ordered and can not have duplicates
        Set<Integer> st = new java.util.LinkedHashSet<>();
        st.add(1);
        st.add(8);
        st.add(10);
        st.add(13);
        st.add(14);
        st.add(10);
        System.out.println(st);
    }
}
