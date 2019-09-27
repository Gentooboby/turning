package com.apple.thinking.extend;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Dept extends User{
    private int age;

    public Dept(String name, int age) {
        super(name);
        this.age = age;
    }

    public void update(String name, int age){
        set(name);
        this.age = age;
    }
}

class Manage {
    private User user;

    public Manage(){
        user = new User("team");
    }

    public void modify(){
        user.set("bob" );
    }
}
