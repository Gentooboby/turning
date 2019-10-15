package com.apple.thinking.enums;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class EnumsMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(AlarmPoints.BATHROOM, () -> System.out.println("Bathroom alert!"));

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.println(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}

interface Command {
    void action();
}
