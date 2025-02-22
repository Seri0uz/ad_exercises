package ch.hslu.sw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testFibRec1() {
        assertEquals(233,Fibonacci.fiboRec1(13));
        assertEquals(377,Fibonacci.fiboRec1(14));
    }

    @Test
    void testFibRec2() {
        assertEquals(233,Fibonacci.fiboRec2(13,new int[14]));
        assertEquals(377,Fibonacci.fiboRec2(14,new int[15]));
    }

    @Test
    void testFibItr() {
        assertEquals(233,Fibonacci.fiboItr(13));
        assertEquals(377,Fibonacci.fiboItr(14));
    }

}