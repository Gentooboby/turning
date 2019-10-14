package com.apple.thinking.enums.menu;

import com.apple.util.Enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum Course {
    APPERIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Desset.class),
    COFFEE(Food.Coffe.class);

    private Food[] values;

    Course(Class<? extends Food> kind) {
        this.values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
