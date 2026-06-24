package com.example.Collections.queue.blockingQueue.programs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProgramOne {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3);
        Thread t1 = new Thread(() -> {
            try {
                bq.put(1);
                System.out.println(bq);
                bq.put(2);
                System.out.println(bq);
                bq.put(3);
                System.out.println(bq);
                bq.put(4);
                System.out.println(bq);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("bq consumed " + bq.take());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
