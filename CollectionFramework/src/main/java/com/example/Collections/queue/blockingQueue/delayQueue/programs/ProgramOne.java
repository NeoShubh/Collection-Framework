package com.example.Collections.queue.blockingQueue.delayQueue.programs;

import java.util.concurrent.*;

class Task implements Delayed {
    String name;
    long expiryTime; // when this task becomes available

    Task(String name, long delayInSeconds) {
        this.name = name;
        this.expiryTime = System.currentTimeMillis() + (delayInSeconds * 1000);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = expiryTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(
                this.getDelay(TimeUnit.MILLISECONDS),
                other.getDelay(TimeUnit.MILLISECONDS)
        );
    }

    @Override
    public String toString() {
        return name;
    }
}

public class ProgramOne {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Task> queue = new DelayQueue<>();

        queue.put(new Task("Task A", 3)); // available after 3 seconds
        queue.put(new Task("Task B", 1)); // available after 1 second
        queue.put(new Task("Task C", 5)); // available after 5 seconds

        System.out.println("All tasks added...");

        while (!queue.isEmpty()) {
            Task task = queue.take(); // waits until delay expires
            System.out.println("Executing: " + task
                    + " at " + System.currentTimeMillis());
        }
    }
}