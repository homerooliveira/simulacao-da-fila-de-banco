package com.pucrs.aee;


public interface QueueTAD<E> {
    int size();

    boolean isEmpty();

    void clear();

    void enqueue(E element);

    E dequeue();

    E front();
}
