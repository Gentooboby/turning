package com.apple.pattern.bridge;

public class BridgePattern {


    public static void drawCircle() {
        Shape redCircle = new Circle(3, 5, 6, new RedCircle());
        Shape greenCircle = new Circle(4, 5, 6, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

    public static void main(String[] args) {
        drawCircle();
    }
}
