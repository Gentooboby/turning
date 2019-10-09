package com.apple.thinking.interfaces;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Person {
    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        Chinese.h(chinese);


    }
}

abstract class User {
    public void f(){
        print("User.f()");
    }

}

class Chinese extends User {
    public void g() {
        print("Chinese.g()");
    }

    static Chinese h(User user) {
        return ((Chinese) user);
    }
}
