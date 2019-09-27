package com.apple.thinking.extend;

import java.math.BigDecimal;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
class Cleaner {
    private String s = "Cleaner";

    protected void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleaner c = new Cleaner();
        c.dilute();
        c.apply();
        c.scrub();
        System.out.println(c);
    }
}

/**
 * @author lu.chen
 */
public class Detergent extends Cleaner {

    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    public static void main(String[] args) {
        Detergent d = new Detergent();
        d.dilute();
        d.apply();
        d.scrub();
        d.foam();
        System.out.println(d);
        System.out.println("Testing base class");
        Cleaner.main(args);

    }
}