package com.pucrs.aee;

import java.util.NoSuchElementException;

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
        Node node = new Node(element);
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
            throw new NoSuchElementException();
        }

        Node node = head;
        head = node.next;
        count--;
        return node.element;
    }

    @Override
    public E front() {
        if (count == 0) {
            throw new NoSuchElementException();
        }

        return head.element;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        Node atual = head;
        boolean primeiro = true;

        while (atual != null) {
            if (!primeiro) {
                sb.append(", ");
            }
            sb.append(atual.element);
            atual = atual.next;
            primeiro = false;

        }
        sb.append(']');
        return sb.toString();
    }

    private class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

    }
}
