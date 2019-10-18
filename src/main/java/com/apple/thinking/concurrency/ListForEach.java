package com.apple.thinking.concurrency;


import javax.xml.stream.events.EndDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class ListForEach {

    public static void add(List<String> list, int capicity) {
        for (int i = 0; i < capicity; i++) {
            list.add(i, "lu-->" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        add(list, 10000000);
        long start = System.currentTimeMillis();
        synchronized (list) {

        }

        poolDeal(list);
//        normalDeal(list);
        long end = System.currentTimeMillis();
        System.out.println("----------------------"+ (end - start));
    }


    private static void normalDeal(List<String> list) {
        list.forEach(s -> System.out.println(s));
    }

    private static void poolDeal(List<String> list) {
        ExecutorService exec = new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (String s : list) {
            exec.submit(() -> System.out.println(s));
        }
//        exec.shutdown();
    }
}
