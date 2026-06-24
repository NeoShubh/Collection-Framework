package com.example.Collections.queue.PriorityQueue.programs;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class programOne {
    public static void main(String [] args){
//        Queue<Integer> q = new PriorityQueue<>();
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(100);
        q.offer(10);
        q.offer(1000);
        q.offer(99);
        System.out.println(q);
    }
}

