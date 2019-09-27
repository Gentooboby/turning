package com.apple.thinking.extend;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class User {
    private String name;

    protected void set(String nm) {
        this.name = nm;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a User and my name is : " + name;
    }
}
