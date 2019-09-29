package com.apple.thinking.polymorphism.shape;

import java.util.Random;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class RandomShapeGenerator {
    private Random random = new Random(47);

    public Shape next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}
