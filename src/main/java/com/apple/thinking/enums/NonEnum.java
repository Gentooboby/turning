package com.apple.thinking.enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;

        try {
            for (Object o : intClass.getEnumConstants()) {
                System.out.println(o);
            }
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
}
