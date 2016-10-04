package com.pucrs.aee;

/**
 * Created by Junior on 03/10/2016.
 */
public interface QueueTAD<E> {
    int size();

    boolean isEmpty();

    void clear();


    void enqueue(E element);

    E dequeue();
}
