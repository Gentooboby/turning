package com.apple.thinking.polymorphism.music;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Music2 {
    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Brass i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed stringed = new Stringed();
        Brass brass = new Brass();

        tune(flute);
        tune(stringed);
        tune(brass);
    }
}

class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        print("Stringed.play()" + n);
    }
}

class Brass extends Instrument {
    @Override
    public void play(Note n) {
        print("Brass.play()" + n);
    }
}
