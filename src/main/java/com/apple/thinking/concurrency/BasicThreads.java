package com.apple.thinking.concurrency;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
