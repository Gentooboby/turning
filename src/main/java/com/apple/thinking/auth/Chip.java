package com.apple.thinking.auth;

import com.apple.thinking.initclear.Cookie;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Chip extends Cookie{
    public Chip() {
        System.out.println("Chip constructor");
    }

    public void chomp(){
        bite();
    }
}
