package com.apple.algo.linkedlist;

/**
 * 基于单链表lRU算法（least recently used ）
 *
 * @param <T>
 */
public class LRUBaseLinkedList<T> {
    /**
     * 默认链表容量
     */
    private static final Integer default_capacity = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;
    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = default_capacity;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表头部
        if (preNode != null) {
            deleteElementOptim(preNode);
            insertElementAtBegin(data);
        } else {
            if (length >= capacity) {
                //删除尾结点
                deleteElementAtEnd();
            }

            insertElementAtBegin(data);
        }
    }

    /**
     * 获取查找到元素的前一个节点
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除preNode下一个节点元素
     *
     * @param preNode
     */
    private void deleteElementOptim(SNode preNode) {
        SNode next = preNode.getNext();
        preNode.setNext(next.getNext());
        next = null;
        length--;

    }

    /**
     * 链表头部插入元素
     *
     * @param data
     */
    private void insertElementAtBegin(T data) {
        SNode node = headNode.getNext();
        headNode.setNext(new SNode(data, node));
        length++;
    }

    /**
     * 删除尾结点
     */
    private void deleteElementAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }


    public void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     * 节点
     *
     * @param <T>
     */
    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

}


