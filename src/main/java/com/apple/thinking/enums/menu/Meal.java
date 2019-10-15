package com.apple.thinking.enums.menu;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("***");
        }
    }
}
