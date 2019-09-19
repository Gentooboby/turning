package com.apple.algo.linkedlist;

/**
 * 1)单链表的插入、删除、查找操作
 * 2）链表中存储的是int类型的数据
 */
public class SinglyLinkedList {
    private Node head = null;

    public Node getHead() {
        return head;
    }

    public Node findByValue(int value) {
        Node p = head;

        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }

        return p;
    }

    // 无头结点、表头插入、这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);

        insertToHead(newNode);
    }

    public void insertToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    // 顺序插入、链表尾部插入
    public void insertTail(int value) {
        Node node = new Node(value, null);
        insertTail(node);
    }

    public void insertTail(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }

//            node.next = q.next;
            q.next = node;
        }
    }

    public void insetAfter(Node node, int value) {
        Node newNode = new Node(value, null);
        insertAfter(node, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node node, int value) {
        Node newNode = new Node(value, null);
        insertBefore(node, newNode);
    }

    public void insertBefore(Node node, Node newNode) {
        if (node == null) return;

        if (head == node) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q.next != null && q.next != node) {
            q = q.next;
        }

        if (q == null) return;

        newNode.next = node;
        q.next = newNode;

    }

    public void deleteByNode(Node node) {
        if (head == null) return;

        if (head == node) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != node) {
            q = q.next;
        }

        if (q == null) return;

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node q = head;
        Node p = null;

        while (q.next != null && q.data != value) {
            p = q;
            q = q.next;
        }

        if (q == null) return;

        if (p.data == value) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }

    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }

        System.out.println();
    }


    // 判断true or false
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                break;
            }
        }

        System.out.println("什么结果");
        if (l == null && r == null) {
            System.out.println("什么结果");
            return true;
        } else {
            return false;
        }
    }

    // 判断是否为回文
    public boolean palindrome() {
        if (head == null) return false;

        System.out.println("开始执行找到中间节点");
        Node p = head;
        Node q = head;

        if (p.next == null) {
            System.out.println("只有一个元素");
            return true;
        }

        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }


        System.out.println("中间节点" + p.data);
        System.out.println("开始执行奇数节点回文判断");
        Node leftLink = null;
        Node rightLink = null;

        if (q.next == null) {
            // p一定为整个链表的中点，切节点数目为奇数
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
            System.out.println("左边第一个节点" + leftLink.data);
            System.out.println("右边第一个节点" + rightLink.data);
        } else {
            // p q均为中点
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
        }

        return TFResult(leftLink, rightLink);
    }

    /**
     * 带节点的链表翻转
     */
    public Node inverseLinkList_head(Node p) {
        // head 为新建的头结点
        Node newHead = new Node(9999, null);
        // p 为原来整个链表的头结点，现在newead指向整个链表
        newHead.next = p;

        /**
         * 带头结点的链表翻转等价于从第二个元素开始重新头插法建立链表
         */
        Node cur = p.next;
        p.next = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            System.out.println("first " + head.data);
            cur = next;
        }

        // 返回左半部分的中点之间的那个节点
        // 从此处开始同步向两边比较
        return head;
    }

    /**
     * 无头结点的链表翻转
     */
    public Node inverseLinkList(Node node) {
        Node pre = null;
        Node r = head;
        System.out.println("z----" + r.data);
        Node next = null;
        while (r != node) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        // 返回左半部分的中点之前的那个节点
        // 从此处开始同步像两边比较
        return r;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
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

        public Node getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        System.out.println("hello");

//        int[] data = {1};
//        int[] data = {1, 2};
//        int[] data = {1,2,3,1};
//        int[] data = {1, 2, 5};
//        int[] data = {1,2,2,1};
        int[] data = {1, 2, 5, 2, 1};
//        int[] data = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
//            linkedList.insertToHead(data[i]);
            linkedList.insertTail(data[i]);
        }

//        linkedList.printAll();
//
//        Node p = linkedList.inverseLinkList(linkedList.head);
//        while (p != null) {
//            System.out.println("data " + p.data);
//            p = p.next;
//        }

        System.out.println("打印原始：");
        linkedList.printAll();

        if (linkedList.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }

}
