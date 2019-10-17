package com.apple.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i<5;i++) {
            executor.execute(new LiftOff());
        }
        executor.shutdown();
    }
}
