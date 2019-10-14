package com.apple.thinking.enums;

import com.apple.util.Enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Enums.random(Activity.class));
    }
}

enum Activity {
    SITTING, LYING, STANDING, HOPPING, RUUNING, DODGING, JUMPING, FALLING, FLAYING
}
