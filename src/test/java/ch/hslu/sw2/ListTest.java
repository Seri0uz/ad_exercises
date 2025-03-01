package ch.hslu.sw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    private List list;

    @BeforeEach
    public void setup(){
        list = new List<Integer>();
    }

    @Test
    void testAddValue(){
        list.add(new Node<Integer>(4));
        list.add(new Node<Integer>(2));
        list.add(new Node<Integer>(3));
        assertEquals(3, list.size());
    }

    @Test
    void testSearchValue(){
        list.add(new Node<Integer>(4));
        assertTrue(list.search(4));
    }

    @Test
    void testPop(){
        Node<Integer> node = new Node<>(8);
        Node<Integer> node1 = new Node<>(9);
        list.add(node);
        list.add(node1);
        list.pop();
        assertFalse(list.search(9));
    }

    @Test
    void testPopReturn(){
        list.add(new Node<Integer>(7));
        assertEquals(7,list.pop().getValue());
    }

    @Test
    void testPopEmpty(){
        list.pop();
        assertNull(list.getHead());
    }

    @Test
    void testRemoveValue(){
        list.remove(new Node<Integer>(1));
        assertFalse(list.search(1));
    }




}