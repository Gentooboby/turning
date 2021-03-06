package com.apple.algo.stack;

/**
 * 基于链表实现的栈 先进后出 FILO first in last out
 */
public class StackBaseOnLinkedList {
    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 用-1表示没有数据
     */
    public int pop() {
        if (top == null) return -1;

        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.println(p + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

    }
}
