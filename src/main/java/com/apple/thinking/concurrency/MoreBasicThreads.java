package com.apple.thinking.concurrency;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
            System.out.println("Waiting for leftOff " + Thread.currentThread().getName());
        }
    }
}
