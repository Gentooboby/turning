package com.apple.thinking.extend;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Cartoon extends Drawing {
//    public Cartoon() {
//        System.out.println("Cartoon constructor");
//    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
//    Drawing() {
//        System.out.println("Drawing constructor");
//    }
}