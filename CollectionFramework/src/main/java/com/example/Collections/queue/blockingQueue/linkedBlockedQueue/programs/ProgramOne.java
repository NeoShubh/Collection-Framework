package com.example.Collections.queue.blockingQueue.linkedBlockedQueue.programs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProgramOne {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer starting...");

                queue.put(1);
                System.out.println("Produced: 1 | Queue: " + queue);

                queue.put(2);
                System.out.println("Produced: 2 | Queue: " + queue);

                queue.put(3);
                System.out.println("Produced: 3 | Queue: " + queue);

                System.out.println("Queue is FULL — producer waiting...");
                queue.put(4); // waits here until consumer takes
                System.out.println("Produced: 4 | Queue: " + queue);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(3000); // slow consumer — wait 3 seconds
                System.out.println("Consumer woke up — taking element");

//                int val = queue.take();
                System.out.println("Consumed: " + queue.take() + " | Queue: " + queue);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
//Producer starting...
//Produced: 1 | Queue: [1]
//Produced: 2 | Queue: [1, 2]
//Produced: 3 | Queue: [1, 2, 3]
//Queue is FULL — producer waiting...
//Consumer woke up — taking element //it actually remove the 1 and gona print [2,3] but producer jumps in and print so the last line should come first than last one
//Produced: 4 | Queue: [2, 3, 4]
//Consumed: 1 | Queue: [2, 3] this two gets swapped and print in wrong order although  the program is right