package com.apple.thinking.concurrency.synchronizeds;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Using Explicit lock objects to create critical sections
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager
                p = new ExplicitPairManager1(),
                p2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(p, p2);
    }
}

/**
 * synchronize the entire method
 */
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

/**
 * TODO 线程不安全
 * use a critical section
 */
class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
