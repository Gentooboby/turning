package com.apple.thinking.concurrency.synchronizeds;

import com.apple.thinking.concurrency.EvenChecker;
import com.apple.thinking.concurrency.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
