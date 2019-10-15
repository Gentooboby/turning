package com.apple.thinking.interfaces;

import java.util.Random;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public interface RandomDoubles {
    Random RAND = new Random(47);

    default double next() {
        return RAND.nextDouble();
    }

    static void main(String[] args) {
        RandomDoubles r = new RandomDoubles() {};

        for (int i = 0; i < 7; i++) {
            System.out.println(r.next() + " ");
        }
    }

}
