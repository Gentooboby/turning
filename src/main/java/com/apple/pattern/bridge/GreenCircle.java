package com.apple.pattern.bridge;

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("draw circle [color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}
