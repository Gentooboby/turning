package com.apple.algo.linkedlist;

/**
 * 1）单链表反转
 * 2）链表中环的检测
 * 3）两个有序的链表合并
 * 4）求链表的中间节点
 */
public class LinkedListAlgo {
    private Node head;

    /**
     * 单链表反转
     */
    public static Node reverse(Node list) {
        Node cur = list;
        Node pre = null;

        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 检测环
     */
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * 有序链表合并
     */
    public static Node mergeSortedList(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }

            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head;
    }


    /**
     * 有序链表合并 LeetCode 21
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 利用哨兵结点简化实现难度，技巧三
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;

        return soldier.next;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    /**
     * 删除倒数第K个节点
     */
    public static Node deleteLastKth(Node list, int index) {
        Node fast = list;
        int i = 1;

        while (fast != null && i < index) {
            fast = fast.next;
            i++;
        }

        if (fast == null) return list;


        Node slow = list;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        // TODO 代码是否没bug
        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }

        return list;
    }

    /**
     * 找中间节点
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list){
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
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
    }

    public static Node insert(Node head, int value) {
        Node newNode = createNode(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        return head;
    }


    public static void main(String[] args) {

        int[] data = {8, 0, 3, 4, 6, 1, 9, 90};
        Node node = null;
        for (int i = 0; i < data.length; i++) {
            node = insert(node, data[i]);
        }
        printAll(node);
        System.out.println("-------------------");
        printAll(deleteLastKth(node, 4));
        System.out.println("-------------------");
        printAll(findMiddleNode(node));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
