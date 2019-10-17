package com.apple.thinking.concurrency;

import java.io.IOException;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true)
            d = d + (Math.PI + Math.E) / d;
    }

    public static void main(String[] args) throws IOException {
//        UnResponsiveUI unResponsiveUI = new UnResponsiveUI();
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}

class UnResponsiveUI {
    private volatile double d = 1;

    public UnResponsiveUI() throws IOException {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}
