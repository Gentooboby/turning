package com.apple.thinking.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            results.add(threadPool.submit(new TaskWithResult(i)));
        }

        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                threadPool.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of taskWithResult " + id;
    }
}
