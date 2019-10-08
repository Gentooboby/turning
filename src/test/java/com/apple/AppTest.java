package com.apple;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    public static void main(String[] args) {
        String str = "100积分肝功能";
        System.out.println(str.indexOf("积"));
//        System.out.println(str.substring(0,str.indexOf("积")));

        System.out.println(str.replace("[^0-9]",""));
    }
}
