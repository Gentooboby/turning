package com.apple.algo.linkedlist;

public class LRUBaseArrayTest {

    public static void main(String[] args) {

        testSpecialConstructor(4);
//        testDefaultConstructor();

    }

    public static void testWithExceptionn() {
        LRUBaseArray<Integer> lru = new LRUBaseArray<>();
        lru.offer(null);
    }

    public static void testDefaultConstructor() {
        System.out.println("===========无参构造器==============");
        LRUBaseArray<Integer> lru = new LRUBaseArray<>();

        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        System.out.println(lru);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        System.out.println(lru);
    }


    public static void testSpecialConstructor(int capacity) {
        System.out.println("============有参构造器=================");
        LRUBaseArray<Integer> lru = new LRUBaseArray(capacity);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(3);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(7);
        System.out.println(lru);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);

    }
}
