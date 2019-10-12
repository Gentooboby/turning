package com.apple.thinking.interfaces;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Adventure {
}

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {

    }

    @Override
    public void fly() {

    }
}