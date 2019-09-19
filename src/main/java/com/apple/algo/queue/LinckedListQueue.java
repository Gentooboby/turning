package com.apple.algo.queue;

/**
 * 基于链表实现的队列
 */
public class LinckedListQueue {
    private Node head = null;
    private Node tail = null;

    /**
     * 入队操作
     *
     * @param item
     * @return
     */
    public void enQueue(String item) {
        if (tail == null) {
            Node node = new Node(item, null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) return null;

        String data = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        return data;
    }

    public void printAll() {
        Node n = head;

        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinckedListQueue queue = new LinckedListQueue();

        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.printAll();
        queue.dequeue();
        System.out.println();
        queue.printAll();

    }
}
