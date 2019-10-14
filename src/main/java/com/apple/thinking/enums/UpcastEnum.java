package com.apple.thinking.enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        for (Search val : vals) {
            System.out.println(val);
        }

        System.out.println("--------------------");

        Enum e = Search.HITHER;
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}

enum Search {
    HITHER, YON
}
