package com.apple.thinking.enumerated;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum OzWitch {
    WEST("miss gulch, aka the wicked witch of the west"),
    NORTH("glinda, the good witch of north"),
    EAST("east"),
    SOUTH("SOUTH");


    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : OzWitch.values()) {
            System.out.println(ozWitch + ": " + ozWitch.getDescription());
        }
    }
}
