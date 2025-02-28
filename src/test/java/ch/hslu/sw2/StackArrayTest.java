package ch.hslu.sw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {
    @Test
    void testPush() {
        StackArray<Integer> stack = new StackArray<>(1);
        stack.push(5);
        assertEquals(1, stack.size());
    }

    @Test
    void testPushOverflow() {
        StackArray<Integer> stack = new StackArray<>(0);
        final StackOverflowError e = assertThrows(StackOverflowError.class, () -> {
            stack.push(5);
        });
        assertEquals("Stack is full",e.getMessage());
    }

    @Test
    void testPop() {
        StackArray<Integer> stack = new StackArray<>(2);
        stack.push(5);
        stack.push(6);
        stack.pop();
        assertEquals(1, stack.size());

    }

    @Test
    void testPopNull() {
        StackArray<Integer> stack = new StackArray<>(0);
        assertNull(stack.pop());
    }


    @Test
    void testIsEmpty() {
        StackArray<Integer> stack = new StackArray<>(1);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsFull() {
        StackArray<Integer> stack = new StackArray<>(1);
        stack.push(5);
        assertTrue(stack.isFull());
    }

    @Test
    void testSize() {
        StackArray<Integer> stack = new StackArray<>(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        assertEquals(3, stack.size());
    }

    @Test
    void testSizeZero() {
        StackArray<Integer> stack = new StackArray<>(2);
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void testPeek() {
        StackArray<Integer> stack = new StackArray<>(3);
        stack.push(5);
        stack.push(6);
        assertEquals(5, stack.peek());
    }

}