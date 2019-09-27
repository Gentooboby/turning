package com.apple.thinking.extend;

import static com.apple.util.Print.print;

/**
 * final和private关键字
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OP2 op2 = new OP2();
        op2.f();
        op2.g();

        /**
         * you can up cast, but you can't call the method
         */
        OverridingPrivate op = op2;
//        op.f();
//        op.g();

        WithFinal wf = op;
//        wf.f();
//        wf.g();
    }
}

class WithFinal {
    private final void f() {
        print("withfinal.f()");
    }

    private void g() {
        print("withfinal.g()");
    }
}

class OverridingPrivate extends WithFinal {
    private final void f() {
        print("overridingPrivate.f()");
    }

    private void g() {
        print("overridingPrivate.g()");
    }
}

class OP2 extends OverridingPrivate {
    public final void f() {
        print("OP2.f()");
    }

    public void g() {
        print("OP2.g()");
    }
}


class SmallBrain {
}

final class Dinosaur {
    int i = 7;

}
//class a extends Dinosaur{}