package com.apple.thinking.polymorphism.over;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class PrivateOverride {
    private void f() {
        print("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride p = new PrivateOverride();
        p.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        print("public f()");
    }
}
