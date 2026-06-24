package com.example.Collections.queue.deque.arrayDaque.programs;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProgramOne {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(1);
        dq.offerLast(4);
        dq.offer(3); // it inserts in the last
        System.out.println(dq);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
        System.out.println(dq.peek());
        dq.pollFirst();
        System.out.println(dq);
        dq.pollLast();
        System.out.println(dq);
        dq.poll();
        System.out.println(dq);

//        using it as stack
        Deque<Integer> stack = new ArrayDeque<>();

        stack.offerFirst(10);  // push
        stack.offerFirst(20);  // push
        stack.offerFirst(30);  // push

        System.out.println(stack); // [30, 20, 10]

        stack.pollFirst(); // pop → 30
        stack.pollFirst(); // pop → 20

        System.out.println(stack); // [10]

//        using it as queue
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offerLast(10);  // enqueue
        queue.offerLast(20);  // enqueue
        queue.offerLast(30);  // enqueue

        System.out.println(queue); // [10, 20, 30]

        queue.pollFirst(); // dequeue → 10
        queue.pollFirst(); // dequeue → 20

        System.out.println(queue); // [30]

    }


}
