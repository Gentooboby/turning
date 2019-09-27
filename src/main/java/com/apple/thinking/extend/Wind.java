package com.apple.thinking.extend;

import static com.apple.util.Print.print;

/**
 * 向上转型
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute);
    }

}

class Instrument {
    public void play() {
        print("play instrument");
    }

    static void tune(Instrument i) {
        i.play();
    }
}
