package com.apple.thinking.polymorphism.access;

/**
 * 静态方法，他的行为不具有多态性
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class StaticPolymorphsim {
    public static void main(String[] args) {
        StaticSuper ss = new StaticSub();
        System.out.println(ss.staticGet());
        System.out.println(ss.dynamicGet());
    }
}

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet(){
        return "Derived staticGet()";
    }

    @Override
    public String dynamicGet(){
        return "Derived staticGet()";
    }
}
