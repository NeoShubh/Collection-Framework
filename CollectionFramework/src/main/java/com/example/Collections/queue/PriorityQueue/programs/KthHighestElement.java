package com.example.Collections.queue.PriorityQueue.programs;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthHighestElement {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
//        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 2;
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer(num);
            if(q.size()>k)
                q.poll();
        }
        System.out.println(q.peek());
        int [] answer = q.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(q);
    }
}