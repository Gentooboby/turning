package com.apple.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            execute.execute(new LiftOff());
        }
        execute.shutdown();
    }
}
