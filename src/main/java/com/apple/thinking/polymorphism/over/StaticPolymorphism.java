package com.apple.thinking.polymorphism.over;

/**
 * 如果某个方法是静态的，它的行为就不具有多态性
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}

class StaticSuper {
    public static String staticGet(){
        return "Base staticGet()";
    }

    public String dynamicGet(){
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper{
    public static String staticGet(){
        return "Derived staticGet()";
    }

    @Override
    public String dynamicGet(){
        return "Derived dynamicGet()";
    }
}
