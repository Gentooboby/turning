package com.apple.thinking.initclear;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }

//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();
}

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        System.out.println("static block");
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

