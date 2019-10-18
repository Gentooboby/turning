package com.apple.thinking.concurrency.synchronizeds;

import com.apple.thinking.concurrency.EvenChecker;
import com.apple.thinking.concurrency.IntGenerator;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
