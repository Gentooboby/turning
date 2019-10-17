package com.apple.thinking.concurrency;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy", 1000),
                grumpy = new Sleeper("Grumpy", 5000);

        Joiner depey = new Joiner("Dopey", sleeper),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }

}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print("is Interrupt" + isInterrupted());
            return;
        }

        print(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            print("InterruptedException");
        }
        print(getName() + " join completed");
    }
}