package com.apple.jg.impl;

import com.apple.jg.Formula;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FormulaImpl implements Formula {
    @Override
    public double calculate(int a) {
        return sqrt(a * 10);
    }

}
