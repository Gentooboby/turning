package com.apple.thinking.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }

        /**
         * run for a while, then stop and collect the data
         */
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();

        if (exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("some tasks were not terminated");
        }

        System.out.println("total: " + Entrance.getTotalCount());
        System.out.println("sum of entrances: " + Entrance.sumEntrances());
    }
}

class Count {
    private int count = 0;
    private Random random = new Random(47);

    /**
     * remove the synchronized keyword to see counting fail
     */
    public synchronized int increment() {
        int temp = count;
        // Yield half the time
        if (random.nextBoolean()) {
            Thread.yield();
        }

        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;

    /**
     * Doesn't need synchronization to read
     */

    private final int id;

    private static volatile boolean canceled = false;

    /**
     * Atomic operation on a volatile field
     */
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        /**
         * keep this task in a list . also prevents
         *
         * garbage collection on a volatile field
         */
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }

            System.out.println(this + " total: " + count.increment());

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }

        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}
