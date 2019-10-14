package com.apple.jg;

/**
 * default method for interfaces
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public interface Formula {
    double calculate(int a);

    /**
     * default method
     *
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
