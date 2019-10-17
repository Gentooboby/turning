package com.apple.thinking.concurrency;

import java.util.concurrent.*;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(0, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
