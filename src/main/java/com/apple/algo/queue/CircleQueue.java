package com.apple.algo.queue;

/**
 * 循环队列
 */
public class CircleQueue {
    // 数组items，数组大小n
    private String[] items;
    private int n = 0;

    // head队列头，tail队列尾
    private int head = 0;
    private int tail = 0;

    public CircleQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队操作
    public boolean enqueue(String item) {
        // 判断队列是否满了
        if ((tail + 1) % n == head) return false;

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队操作
    public String dequeue() {
        if (head == tail) return null;

        String data = items[head];
        head = (head + 1) % n;
        return data;
    }

    public void printAll() {
        if (n == 0) return;

        for (int i = head; i % n != tail; i++) {
            System.out.println(items[i % n]);
        }

        System.out.println();
    }


    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        queue.printAll();
        queue.enqueue("e");
        String item = queue.dequeue();
        queue.printAll();
        System.out.println(item);
        queue.dequeue();
        queue.enqueue("F");
        queue.enqueue("h");
        System.out.println();
        queue.printAll();

        System.out.println();
        queue.dequeue();
        queue.enqueue("M");
        queue.printAll();

    }


}
