package com.apple.thinking.enums.menu;

import com.apple.util.Enums;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum Meal12 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Desset.class),
    COFFEE(Food.Coffe.class);

    private Food[] values;

    Meal12(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROOLS
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAL, LENTILS, HUMMOUS, VINDALOO;
        }

        enum Desset implements Food {
            TIRAMISU, GELATO, BALACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
        }

        enum Coffe implements Food {
            BLACK_COFFE, DECAF_COFFE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA
        }

    }

    public Food randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal12 meal12 : Meal12.values()) {
                Food food = meal12.randomSelection();
                System.out.println(food);
            }
            System.out.println("***");
        }
    }
}
