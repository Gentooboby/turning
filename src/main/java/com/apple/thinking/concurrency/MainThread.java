package com.apple.thinking.concurrency;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
