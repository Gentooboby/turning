package com.apple.thinking.polymorphism.access;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FieldAccess {

    public static void main(String[] args) {
        Super s = new Sub();
        System.out.println("sup.field = " + s.field + ". sup.getField() = " + s.getField());

        Sub sub = new Sub();

        System.out.println("sub.field = " + sub.field + ". sub.getField() = " + sub.getField() + ". sub.getSuperField = " + sub.getSuperField());
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
