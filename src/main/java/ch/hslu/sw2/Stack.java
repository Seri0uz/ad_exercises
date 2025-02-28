package ch.hslu.sw2;

public interface Stack<T> {

    boolean isEmpty();
    boolean isFull();
    int size();
    void push(T element);
    T peek();
    T pop();
}
