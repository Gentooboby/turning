package com.apple.thinking.enums;

import java.util.EnumSet;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class CarWash {

    public enum Cycle {
        UNDER_BODY {
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEEL_WASH {
            @Override
            void action() {
                System.out.println("washing the wheels");
            }
        },
        PRE_WASH {
            @Override
            void action() {
                System.out.println("loosening the dirt");
            }
        },
        BASIC {
            @Override
            void action() {
                System.out.println("the basic wash");
            }
        },
        HOT_WAX {
            @Override
            void action() {
                System.out.println("applying hot wax");
            }
        },
        RINSE {
            @Override
            void action() {

                System.out.println("rinsing");
            }
        },
        BLOW_DRY {
            @Override
            void action() {
                System.out.println("blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        cycles.forEach(Cycle::action);
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();

        wash.add(Cycle.BLOW_DRY);
        wash.add(Cycle.BLOW_DRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOT_WAX);
        System.out.println(wash);
        wash.washCar();
    }
}
