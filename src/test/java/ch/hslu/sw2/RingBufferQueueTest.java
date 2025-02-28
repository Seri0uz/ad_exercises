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


}