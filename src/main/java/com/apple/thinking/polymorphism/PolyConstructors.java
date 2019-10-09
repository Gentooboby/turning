package com.apple.thinking.polymorphism;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Glyph {
    void draw() {
        print("Glyph.draw()");
    }

    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(). radius = " + radius);
    }

    @Override
    void draw() {
        print("RoundGlyph.draw(). radius = " + radius);
    }
}
