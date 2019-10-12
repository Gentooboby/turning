package com.apple.thinking.annotations.databases;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
