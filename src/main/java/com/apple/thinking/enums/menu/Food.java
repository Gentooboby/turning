package com.apple.thinking.enums.menu;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
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


