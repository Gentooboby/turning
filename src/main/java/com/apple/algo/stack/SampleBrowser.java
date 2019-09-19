package com.apple.algo.stack;

/**
 * 使用前后栈实现浏览器的前进后退
 */
public class SampleBrowser {

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("www.baidu.com");
        browser.open("www.sina.com");
        browser.open("www.apple.com");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("www.didi.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();

        browser.checkCurrentPage();


    }

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        backStack = new LinkedListBasedStack();
        forwardStack = new LinkedListBasedStack();
    }

    public void open(String url) {
        if (currentPage != null) {
            backStack.push(this.currentPage);
            forwardStack.clear();
        }

        showUrl(url, "open");
    }

    public boolean canBack() {
        return backStack.size > 0;
    }

    public boolean canForward() {
        return forwardStack.size >= 0;
    }

    public String goBack() {
        if (canBack()) {
            this.forwardStack.push(this.currentPage);
            String url = this.backStack.pop();
            showUrl(url, "back");
            return url;
        }

        System.out.println("cannot go back, no page behind");
        return null;
    }

    public String goForward() {
        if (canForward()) {
            this.backStack.push(this.currentPage);
            String url = this.forwardStack.pop();
            showUrl(url, "forward");
            return url;
        }

        System.out.println("cannot go forward, no page ahead");
        return null;
    }

    public void checkCurrentPage() {
        System.out.println("current page: " + this.currentPage);
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + "page: " + url);
    }

    public static class LinkedListBasedStack {
        private int size;
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            this.size = 0;
        }

        public void push(String data) {
            Node node = createNode(data, top);
            this.top = node;
            this.size++;
        }

        public String pop() {
            Node popNode = this.top;

            if (popNode == null) {
                System.out.println("stack is empty");
                return null;
            }

            this.top = top.next;
            if (this.size > 0) {
                size--;
            }
            return popNode.data;
        }

        public String getTopData() {
            if (this.top == null) return null;

            return this.top.data;
        }

        public int size() {
            return this.size;
        }


        public void print() {
            System.out.println("this stack:");
            Node currentTop = this.top;
            while (currentTop != null) {
                String data = currentTop.data;
                System.out.println("data " + data);
                currentTop = currentTop.next;
            }
            System.out.println();
        }


    }


    public static class Node {
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

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
