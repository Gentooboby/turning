package com.apple.thinking.polymorphism.shape;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Shapes {
    private static RandomShapeGenerator generator = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        for (int i = 0 ; i < shapes.length; i++) {
            shapes[i] = generator.next();
        }

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
