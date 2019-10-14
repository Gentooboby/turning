package com.apple.thinking.enums;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("---- Analyze " + enumClass + " ----");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }

        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Method: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }

        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enums = analyze(Enum.class);

        System.out.println("Explore.containsAll(Enum)?" + exploreMethods.containsAll(enums));
        System.out.println("Explore.removeAll(Enum): " );
        exploreMethods.removeAll(enums);
        System.out.println(exploreMethods);

        // decompile the code for enum
//        OSExecute.command("javap -cp build/classes/main Explore");
    }
}

enum Explore {
    HERE, THERE
}
