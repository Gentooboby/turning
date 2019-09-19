package com.apple;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    public static void main(String[] args) {
        String str = "100积分肝功能";
        System.out.println(str.indexOf("积"));
//        System.out.println(str.substring(0,str.indexOf("积")));

        System.out.println(str.replace("[^0-9]",""));



    }




}
