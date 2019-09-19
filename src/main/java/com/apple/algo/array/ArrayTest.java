package com.apple.algo.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();

        array.insert(0,3);
        array.insert(0,4);
        array.insert(1,5);
        array.insert(3,6);
        array.insert(3,7);

        array.printAll();

    }
}
