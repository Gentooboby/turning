package com.apple.thinking.extend;

import java.util.Random;

import static com.apple.util.Print.print;

/**
 * final关键字
 *
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FinalData {
    private static Random random = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    /**
     * Can be compile-time constants
     */
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    /**
     * Typical public constant
     */
    public static final int VALUE_THREE = 999;

    /**
     * Cannot be compile-time constants
     */
    private final int i4 = random.nextInt(20);
    static final int I_5 = random.nextInt(20);

    private Value v = new Value(1);
    private final Value v2 = new Value(22);
    private static final Value VALUE = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override
    public String toString() {
        return id +": " + "i4 = " + i4 + " . I_5 = " + I_5;
    }


    public static void main(String[] args) {
        FinalData data = new FinalData("finalData1");

        data.v2.i++;
        data.v = new Value(9);
        for (int i = 0; i<data.a.length; i++){
            data.a[i]++;
//            data.v2 = new Value(0);
//            data.VALUE = new Value(1);
//            data.a = new int[3];
            print(data);
            print("Creating new FinalData");
            FinalData data1 = new FinalData("finalData2");
            print(data);
            print(data1);
        }

    }
}

class Value {
    int i; // Package access

    public Value(int i) {
        this.i = i;
    }
}
