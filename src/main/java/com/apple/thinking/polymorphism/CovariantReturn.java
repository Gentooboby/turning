package com.apple.thinking.polymorphism;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain grain = m.process();
        System.out.println(grain);

        m = new WheatMill();
        grain = m.process();
        System.out.println(grain);
    }
}

class Grain {

    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {

    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {

    @Override
    Wheat process() {
        return new Wheat();
    }
}


