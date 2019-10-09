package com.apple.thinking.polymorphism;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}

class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {

    @Override
    public void act() {
        print("HappyActor");
    }
}

class SadActor extends Actor {

    @Override
    public void act() {
        print("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}