package com.apple;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String str = "755,150";
        List<String> list = Arrays.asList(str.split(","));
        if (list.contains(String.valueOf(755L))){
            System.out.println(list.contains(755));
        }
    }
}
