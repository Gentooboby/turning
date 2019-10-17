package com.apple.thinking.concurrency;

/**
 * 显示发射之前的倒计时
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff") + "). " + taskCount + " -->" + Thread.currentThread().getName();
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());

            Thread.yield();
        }
    }
}
