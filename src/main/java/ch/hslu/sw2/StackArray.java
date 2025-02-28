package ch.hslu.sw2;

public class StackArray<T> implements Stack<T> {
    private final T[] stack;
    private int index = 0;

    @SuppressWarnings("unchecked")
    public StackArray(int size) {
        this.stack = (T[]) new Object[size];
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public boolean isEmpty() {
        return this.index == 0;
    }

    @Override
    public boolean isFull() {
        return this.index == this.stack.length;
    }

    @Override
    public void push(T element) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        this.stack[index] = element;
        index+=1;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        this.index-=1;
        T element = this.stack[index];
        stack[index] = null;
        return element;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.stack[index-2];
    }

}
