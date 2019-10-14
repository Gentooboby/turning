package com.apple.thinking.enums.cartoons;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class EnumImplementation {
    public static <T> void printNext(Supplier<T> arg) {
        System.out.print(arg.get() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter c = CartoonCharacter.NUTTY;
        for (int i = 0; i < 10; i++) {
            printNext(c);
        }
    }
}

enum CartoonCharacter implements Supplier<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);

    @Override
    public CartoonCharacter get() {
        return values()[rand.nextInt(values().length)];
    }
}
