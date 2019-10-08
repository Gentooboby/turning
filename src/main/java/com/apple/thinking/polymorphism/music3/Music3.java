package com.apple.thinking.polymorphism.music3;

import com.apple.thinking.polymorphism.music.Note;

import static com.apple.util.Print.print;


/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Music3 {

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] e = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};

        tuneAll(e);
    }
}

class Instrument {

    void play(Note note) {
        print("Instrument.play() " + note);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        print("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note note) {
        print("Wind.play()" + note);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note note) {
        print("Percussion.play()");
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        print("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note note) {
        print("Stringed.play()");
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        print("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    void play(Note note) {
        print("Brass.play()");
    }

    @Override
    void adjust() {
        print("Adjusting Brass");
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note note) {
        print("Woodwind.play()");
    }

    @Override
    String what() {
        return "Woodwind";
    }
}
