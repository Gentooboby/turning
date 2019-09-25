package com.apple.thinking.initclear;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    private int s;
    public static Apple peel(Apple apple) {
//        int a = this.s;
        return apple;
    }

}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
