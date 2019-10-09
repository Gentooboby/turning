package com.apple.thinking.polymorphism.over;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        print("sup.field = " + sup.field + " sup.getField() = " + sup.getField());

        Sub sub = new Sub();
        print("sub.field = " + sub.field + " sub.getField() = " + sub.getField() + " sub.getSuperField() = " + sub.getSuperField());
    }
}

class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}
