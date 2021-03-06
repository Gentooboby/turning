package com.apple.thinking.enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum SpaceShip {
    SOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip spaceShip : values()) {
            System.out.println(spaceShip);
        }
    }
}
