package com.apple.thinking.enums.vending;

import java.util.Random;

/**
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum Input {
    NICKEL(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100),
    TOOTHPASTE(200),
    CHIPS(75),
    SODA(100),
    SOAP(50),
    ABOUT_TRANSACTION {
        @Override
        public int amount() {
            throw new RuntimeException("ABOUT.amount()");
        }
    },
    STOP {
        @Override
        public int amount() {
            throw new RuntimeException("STOP.amount()");
        }
    };

    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    int amount() {
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelection() {
        return values()[random.nextInt(values().length - 1)];
    }
}
