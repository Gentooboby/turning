package com.apple.thinking.enums;

import static com.apple.thinking.enums.Spiciness.*;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(FLAMING));
    }
}
