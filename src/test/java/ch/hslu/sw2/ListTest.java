package ch.hslu.sw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void testSizeOneItem(){
        List list = new List(new Node(1));
        assertEquals(1,list.size());
    }

    @Test
    void testSizeTwoItems(){
        List list = new List(new Node(20, new Node(6)));
        assertEquals(2,list.size());
    }

    @Test
    void testAddValue(){
        List list = new List(new Node(1));
        list.add(new Node(3));
        assertEquals(3,list.getHead().getValue());
        assertEquals(1,list.getHead().getNextValue().getValue());
    }

    @Test
    void testGetValueTrue(){
        List list = new List(new Node(1));
        list.add(new Node(3));
        list.add(new Node(5));
        list.add(new Node(7));
        assertTrue(list.getValue(3));
        assertTrue(list.getValue(5));
        assertTrue(list.getValue(7));
    }

    @Test
    void testGetValueFalse(){
        List list = new List(new Node(1));
        list.add(new Node(7));
        list.add(new Node(5));
        assertFalse(list.getValue(8));
    }

    @Test
    void testFifo(){
        List list = new List(new Node(1));
        list.add(new Node(7));
        list.add(new Node(9));
        list.fifo();
        assertEquals(7,list.getHead().getValue());
    }

    @Test
    void testFifoReturn(){
        List list = new List(new Node(1));
        list.add(new Node(7));
        assertEquals(7,list.fifo());
    }

    @Test
    void testFifoEmpty(){
        List list = new List(new Node(1));
        list.fifo();
        assertNull(list.getHead());
    }




}