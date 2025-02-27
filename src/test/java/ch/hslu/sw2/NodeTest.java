package ch.hslu.sw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    void testGetValue() {
        Node n = new Node(56);
        assertEquals(56,n.getValue());
    }

    @Test
    void testGetNextValue() {
        Node n = new Node(56,new Node(57));
        assertEquals(57,n.getNextValue().getValue());
    }

    @Test
    void testSetValue() {
        Node n = new Node(56);
        n.setValue(78);
        assertEquals(78,n.getValue());
    }

}