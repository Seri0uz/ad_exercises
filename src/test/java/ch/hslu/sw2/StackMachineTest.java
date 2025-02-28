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

}