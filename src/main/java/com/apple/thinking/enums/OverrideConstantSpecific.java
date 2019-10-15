package com.apple.thinking.enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASH {
        @Override
        void f() {
            System.out.println("overridden method");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.println(ocs + ": ");
            ocs.f();
        }
    }
}
