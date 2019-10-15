package com.apple.thinking.interfaces;

import java.util.Random;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public interface RanVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    Long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextFloat() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
