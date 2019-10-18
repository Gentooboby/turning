package com.apple.thinking.concurrency.synchronizeds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class AtomicityTest implements Runnable {
    private int i = 0;

    public int getValue() {
        return i;
    }

    public synchronized void evenIncrement() {
        i++;
        i++;
        System.out.println(i);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val +" --- ");
                System.exit(0);
            }
        }
    }
}
