package com.apple.thinking.enums.vending;

import java.util.EnumMap;

/**
 * TODO 未完待续
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class VendingMachine {


    enum State {
        RESTING {
            @Override
            void next(Input input) {

            }
        };

        abstract void next(Input input);
    }
}

enum Category {
    MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS, Input.SODA, Input.SOAP),
    QUIT_TRANSACTION(Input.ABOUT_TRANSACTION),
    SHUT_DOWN(Input.STOP);

    Input[] values;

    Category(Input... values) {
        this.values = values;
    }

    private static EnumMap<Input, Category> categoryMap = new EnumMap<>(Input.class);

    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input input : category.values) {
                categoryMap.put(input, category);
            }
        }
    }

    public static Category categorize(Input input) {
        return categoryMap.get(input);
    }
}
