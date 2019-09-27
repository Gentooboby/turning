package com.apple.thinking.extend;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Chess extends BoardGame {

    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}

class Game {
    public Game() {
        System.out.println("Game constructor default ");
    }

    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

