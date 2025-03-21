package ch.hslu.sw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    void testGetValue() {
        Node n = new Node<Integer>(56, null);
        assertEquals(56,n.getValue());
    }
}