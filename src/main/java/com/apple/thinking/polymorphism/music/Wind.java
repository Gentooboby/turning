package com.apple.thinking.polymorphism.music;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }
}

class Instrument {
    public void play(Note n) {
        print("Instrument.play()");
    }
}
