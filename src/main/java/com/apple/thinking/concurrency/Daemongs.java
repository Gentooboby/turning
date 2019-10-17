package com.apple.thinking.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Daemongs {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread.isDaemon() = " + thread.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(new daemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started. ");
        }

        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ". ");
        }

        while (true) {
            Thread.yield();
        }
    }
}

class daemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}
