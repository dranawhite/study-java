package com.study.algorithm.list.linked;

/**
 * @author dranawhite
 * @version : SingleLinkedList.java, v 0.1 2019-04-10 18:40 dranawhite Exp $$
 */
public class SingleLinkedList {

    private Node head = new Node(null);

    private Node tail = head;

    private Node current = head;

    public SingleLinkedList() {}

    public SingleLinkedList(String content) {
        char[] chArr = content.toCharArray();
        for (char ch : chArr) {
            add(ch);
        }
    }

    public void add(Object data) {
        Node node = new Node(data);
        tail.next = node;
        tail = node;
    }

    public Object next() {
        if (current.next == null) {
            return null;
        }
        Object data = current.next.data;
        current = current.next;
        return data;
    }

    public boolean hasNext() {
        return current != tail;
    }

    class Node {

        public Node(Object data) {
            this.data = data;
        }

        private Object data;

        private Node next;
    }
}
