package com.apple.thinking.enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class NotClass {
//    void f1(LikeClasses.WINKEN instance){} //nope
}

enum LikeClasses {
    WINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior1");
        }
    },
    BLINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior2");
        }
    },
    NOD {
        @Override
        void behavior() {
            System.out.println("Behavior3");
        }
    };


    abstract void behavior();
}
