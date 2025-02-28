package ch.hslu.sw2;

public class StackMachine {
    private StackArray<Integer> stack;
    public StackMachine(StackArray<Integer> stack) {
        this.stack = stack;
    }
    public void LOAD(int n) {
        stack.push(n);
    }

    public void ADD() {
        int a = stack.get();
        int b = stack.peek();
        int sum = a + b;
        stack.push(sum);
    }

    public void SUB() {
        int a = stack.get();
        int b = stack.peek();
        int sum = a - b;
        stack.push(sum);

    }
    public void MUL() {
        int a = stack.get();
        int b = stack.peek();
        int prod = a*b;
        stack.push(prod);
    }
    public void DIV() {
        int a = stack.get();
        int b = stack.peek();
        int prod = a / b;
        stack.push(prod);
    }
    public int PRINT() {
        return stack.get();
    }
}
