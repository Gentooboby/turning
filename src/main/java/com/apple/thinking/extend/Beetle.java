package com.apple.thinking.extend;

import static com.apple.util.Print.print;

/**
 * 继承和初始化
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Beetle extends Insect {
    private int k = pringInit("Beetle.k initialized");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    private static int x2 = pringInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
}

class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        print("i = " + i + " , j = " + j);
        j = 39;
    }

    private static int x1 = pringInit("static Inset.x1 initialized");

    static int pringInit(String s) {
        print(s);
        return 47;
    }
}
