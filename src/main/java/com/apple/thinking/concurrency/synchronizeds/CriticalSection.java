package com.apple.thinking.concurrency.synchronizeds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class CriticalSection {

    /**
     * test the two different approaches
     *
     * @param pm1
     * @param pm2
     */
    static void testApproaches(PairManager pm1, PairManager pm2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                p1 = new PairManipulator(pm1),
                p2 = new PairManipulator(pm2);
        PairChecker
                pc1 = new PairChecker(pm1),
                pc2 = new PairChecker(pm2);

        exec.execute(p1);
        exec.execute(p2);
        exec.execute(pc1);
        exec.execute(pc2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        System.out.println("p1: " + p1 + "\np2: " + p2);
        System.exit(0);
    }

//    public static void main(String[] args) {
//        PairManager
//                pm1 = new PairManage1(),
//                pm2 = new PairManager2();
//        testApproaches(pm1, pm2);
//    }
}

/**
 * not thread-safe
 */
class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    /**
     * Arbitrary invariant -- both variables must be equal
     */
    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }
}

/**
 * protect a Pair inside a thread-safe class
 */
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        /**
         * make a copy to keep the original safe
         */
        return new Pair(p.getX(), p.getY());
    }

    /**
     * Assume
     *
     * @param p
     */
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {

        }
    }

    /**
     * 自增操作
     */
    abstract void increment();
}

/**
 * Synchronize the entire method
 */
class PairManage1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

/**
 * Use a critical section
 */
class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pairManager;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pairManager.getPair() +
                " checkCounter = " + pairManager.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkState();
        }
    }
}