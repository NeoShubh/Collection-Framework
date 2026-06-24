package com.example.Collections.queue.blockingQueue.priorityBlockingQueue.programs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

//Run the program and see the differnece it does not wait like array and linkedlist blocking queue
public class ProgramOne {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new PriorityBlockingQueue<>(3);
        Thread t1 = new Thread(() -> {
            try {
                bq.put(2);
                System.out.println("Produced new data" + bq);
                bq.put(3);
                System.out.println("Produced new data" + bq);
                bq.put(1);
                System.out.println("Produced new data" + bq);
                bq.put(5);
                System.out.println("Produced new data" + bq);
                bq.put(4);
                System.out.println("Produced new data" + bq);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("consumed new data " + bq.take() + " ||| " + bq);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
