package ch.hslu.sw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferQueueTest {

    @Test
    public void testEnqueue() {
        RingBufferQueue queue = new RingBufferQueue(3);
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        assertEquals(3, queue.size());
    }

    @Test
    public void testDequeue() {
        RingBufferQueue queue = new RingBufferQueue(3);
        queue.enqueue('a');
        queue.enqueue('b');
        assertEquals('a', queue.dequeue());
    }

    @Test
    public void testQueue() {
        RingBufferQueue queue = new RingBufferQueue(3);
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.dequeue();
        queue.enqueue('d');
        queue.dequeue();
        queue.enqueue('e');
        assertEquals('c', queue.dequeue());
    }

    @Test
    public void testIsFull() {
        RingBufferQueue queue = new RingBufferQueue(3);
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        assertTrue(queue.isFull());
    }

    @Test
    public void testIsEmpty() {
        RingBufferQueue queue = new RingBufferQueue(3);
        queue.enqueue('a');
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }



}