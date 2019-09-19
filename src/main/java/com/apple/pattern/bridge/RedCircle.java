package com.apple.pattern.bridge;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("draw circle [color: red, radius: " + radius +
         ", x: " + x + ", y: " + y + "]");
    }
}
