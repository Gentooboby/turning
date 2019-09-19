package com.apple.algo.queue;

/**
 * 数组实现的队列
 */
public class ArrayQueue {
    /**
     * 数组
     */
    private String[] items;
    /**
     * 数组大小
     */
    private int n = 0;
    /**
     * 队头下标
     */
    private int head = 0;
    /**
     * 队尾下标
     */
    private int tail = 0;


    /**
     * 申请一个大小为capacity的数组
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已满
        if (tail == n) return false;

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue(){
        // 如果tail == head 表示队列是空的
        if (tail == head) return null;

        String item = items[head];
        head++;
        return item;
    }

    public void printAll(){
        for (int i = head; i< tail; i++){
            System.out.println(items[i]);

        }

        System.out.println();
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        queue.printAll();

        queue.enqueue("E");
        queue.printAll();

        String s = queue.dequeue();
        System.out.println(s);
        System.out.println();

        queue.printAll();

        queue.enqueue("E");
        queue.printAll();
    }
}
