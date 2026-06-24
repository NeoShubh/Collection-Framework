package com.example.Collections.queue.LinkedListQueue.programs;

import java.util.LinkedList;
import java.util.Queue;

public class ProgramOne {
    public static void main(String [] args){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q);
        System.out.println(q.poll()); //first element
    }
}
