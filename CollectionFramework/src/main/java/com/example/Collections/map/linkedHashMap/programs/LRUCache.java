package com.example.Collections.map.linkedHashMap.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> st = new LRUCache<>(3); //it will store the latest three students and remove the least used one
        st.put("Shubham", 12); //1
        st.put("Alice", 13); //2
        st.put("grahm", 54);// 3
        st.get("Shubham");//we used it now the order becomes Alice,grahm and Shubham So alice will be removed now
        st.put("abhijeet", 5);
        System.out.println(st);
    }
}
