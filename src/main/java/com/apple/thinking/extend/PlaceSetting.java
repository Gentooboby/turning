package com.apple.thinking.extend;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class PlaceSetting extends custom {

    private Spoon spoon;
    private Fork fork;
    private Knife knife;
    private DinnerPlate dinnerPlate;

    private PlaceSetting(int i) {
        super(i + 1);
        spoon = new Spoon(i + 2);
        fork = new Fork(i + 3);
        knife = new Knife(i + 4);
        dinnerPlate = new DinnerPlate(i + 5);
    }

    public static void main(String[] args) {
        PlaceSetting ps = new PlaceSetting(9);
    }
}


class Plate {
    public Plate(int i) {
        print("Plate constructor : " + i);
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor : " + i);
    }
}

class Utensil {
    Utensil(int i) {
        print("Utensil constructor : " + i);
    }
}

class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        print("Spoon constructor : " + i);
    }
}

class Fork extends Utensil {

    Fork(int i) {
        super(i);
        print("Fork constructor : " + i);
    }
}

class Knife extends Utensil {

    Knife(int i) {
        super(i);
        print("Knife constructor : " + i);
    }
}

class custom {
    custom(int i) {
        print("Custom constructor : " + i);
    }
}