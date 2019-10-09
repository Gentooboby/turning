package com.apple.thinking.polymorphism;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {new Useful(), new MoreUseful()};

        x[0].f();
        x[1].g();
        // Compile time: method not found in Useful
//        x[1].u();

        ((MoreUseful)x[1]).u();
        ((MoreUseful)x[0]).u();
    }
}

class Useful {
    public void f() {
    }

    public void g() {
    }
}

class MoreUseful extends Useful {
    @Override
    public void f() {

    }

    @Override
    public void g() {

    }

    public void u() {

    }

    public void v() {

    }

    public void w() {

    }
}
