package com.apple.algo.linkedlist;

import java.util.Scanner;

public class LRUBaseLinkedListTest {
    public static void main(String[] args) {
        System.out.println(8 << 3);
        LRUBaseLinkedList linkedList = new LRUBaseLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            linkedList.add(scanner.nextInt());
            linkedList.printAll();
        }
    }
}
