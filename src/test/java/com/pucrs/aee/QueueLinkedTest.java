package com.pucrs.aee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Junior on 04/10/2016.
 */
public class QueueLinkedTest {
    private QueueTAD<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueLinked<Integer>();
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, queue.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(queue.isEmpty());
    }


    @Test
    public void enqueueAndDequeue() throws Exception {
        queue.enqueue(6);
        assertEquals(Integer.valueOf(6), queue.dequeue());
    }

    @Test
    public void enqueueAndDequeue6Times() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        assertEquals(6, queue.size());
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(4), queue.dequeue());
        assertEquals(Integer.valueOf(5), queue.dequeue());
        assertEquals(Integer.valueOf(6), queue.dequeue());
    }

    @Test
    public void clear() throws Exception {
        queue.enqueue(6);
        queue.clear();
        assertTrue(queue.isEmpty());
    }

}