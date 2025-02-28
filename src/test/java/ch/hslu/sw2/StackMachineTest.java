package ch.hslu.sw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMachineTest {
    @Test
    public void testExerciseA() {
        StackMachine stackMachine = new StackMachine(new StackArray<>(5));
        stackMachine.LOAD(2);
        stackMachine.LOAD(3);
        stackMachine.ADD();
        stackMachine.LOAD(4);
        stackMachine.MUL();
        assertEquals(20,stackMachine.PRINT());
    }

    @Test
    public void testExerciseB() {
        StackMachine stackMachine = new StackMachine(new StackArray<>(3));
        StackMachine stackMachine2 = new StackMachine(new StackArray<>(5));
        stackMachine.LOAD(2);
        stackMachine.LOAD(3);
        stackMachine.ADD();

        stackMachine2.LOAD(4);
        stackMachine2.LOAD(5);
        stackMachine2.ADD();
        stackMachine2.LOAD(stackMachine.PRINT());
        stackMachine2.MUL();
        assertEquals(45,stackMachine2.PRINT());
    }

    @Test
    public void testExerciseC() {
        StackMachine stackMachine = new StackMachine(new StackArray<>(7));
        stackMachine.LOAD(4);
        stackMachine.LOAD(7);
        stackMachine.SUB();
        stackMachine.LOAD(6);
        stackMachine.DIV();
        stackMachine.LOAD(5);
        stackMachine.MUL();
        assertEquals(10,stackMachine.PRINT());
    }

}