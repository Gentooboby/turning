package com.apple.thinking.interfaces;

import com.apple.thinking.polymorphism.music.Note;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Music4 {
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {new Wind(), new Percuss(), new Stringed(), new Brass(), new WoodWind()};
        tuneAll(orchestra);
    }
}

abstract class Instrument {
    private int i;

    public abstract void play(Note n);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument {

    @Override
    public void play(Note n) {
        print("Wind.play() " + n);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {

    }
}

class Percuss extends Instrument {
    @Override
    public void play(Note n) {
        print("Percuss.play() " + n);
    }

    @Override
    public String what() {
        return "Percuss";
    }

    @Override
    public void adjust() {

    }
}

class Stringed extends Instrument {

    @Override
    public void play(Note n) {
        print("Stringed.play() " + n);
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {

    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    public void adjust() {
        print("Brass.adjust()");
    }
}

class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        print("WoodWind.play()");
    }

    @Override
    public String what() {
        return "WoodWind";
    }
}