package com.apple.jg;

import com.apple.jg.impl.FormulaImpl;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FormulaTest {

    public static void main(String[] args) {
        Formula formula = new FormulaImpl();
        double calculate = formula.calculate(10);
        System.out.println(calculate);

        System.out.println(formula.sqrt(9));
    }
}
