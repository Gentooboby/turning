package com.apple.thinking.interfaces.music5;

import com.apple.thinking.polymorphism.music.Note;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Music5 {
    static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e){
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        tuneAll(orchestra);
    }
}


interface Instrument {
    int VALUE = 5; // static & final

    void play(Note note);

    void adjust();
}

class Wind implements Instrument {

    @Override
    public void play(Note note) {
        print(this + ".play() " + note);
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument {

    @Override
    public void play(Note note) {
        print(this + ".play()" + note);
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument {

    @Override
    public void play(Note note) {
        print(this + ".play() " + note);
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

