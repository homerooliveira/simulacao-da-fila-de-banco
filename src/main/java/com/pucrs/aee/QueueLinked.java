package com.pucrs.aee;

/**
 * Created by Junior on 04/10/2016.
 */
public class QueueLinked<E> implements QueueTAD<E> {

    private Node head;
    private Node tail;
    private int count;

    public QueueLinked() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void enqueue(E element) {
        Node node = new Node(element, null);
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    @Override
    public E dequeue() {
        if (count == 0) {
            throw new RuntimeException("count="+count);
        }


        Node node = head;
        int pos = 0;
        while (pos < count - 1) {
            node = node.next;
            pos++;
        }

        count--;

        return node.element;
    }

    private class Node {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("element=").append(element);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
