package com.example.Collections.queue.blockingQueue.synchronousQueue.programs;


import java.util.concurrent.BlockingQueue;

public class SynchronousQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> sq = new java.util.concurrent.SynchronousQueue<>();
        // Producer
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer waiting for consumer...");
                sq.put(42);
                System.out.println("Producer handed off 42!");
            } catch (InterruptedException e) {
            }
        });

// Consumer
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(3000); // consumer takes time to arrive
                System.out.println("Consumer ready — taking now");
                int val = sq.take();
                System.out.println("Consumer received: " + val);
            } catch (InterruptedException e) {
            }
        });

        producer.start();
        consumer.start();
    }
}
