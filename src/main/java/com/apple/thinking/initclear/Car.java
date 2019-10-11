package com.apple.thinking.initclear;

public class Car {
    private Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door(), right = new Door();

    public Car() {
        for (int i = 0; i < 4; i++) {
            wheel[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.getWindows().roolup();
        car.wheel[0].inflate(72);
//        car.engine.start();
    }

}

class Engine {
    private void start() {
        System.out.println("start");
    }

    public void rev() {
        System.out.println("rev");
    }

    public void stop() {
        System.out.println("stop");
    }
}

class Wheel {
    public void inflate(int psi) {
        System.out.println("inflate");
    }
}

class Windows {
    public void roolup() {
        System.out.println("roolup");
    }

    public void roolDown() {
        System.out.println("rooldown");
    }
}

class Door {
    private Windows windows = new Windows();

    public void open() {
        System.out.println("open");
    }

    public void close() {
        System.out.println("close");
    }

    public Windows getWindows() {
        return windows;
    }
}
