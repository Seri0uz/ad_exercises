package ch.hslu.sw2;

public interface Queue {
    void enqueue(char c);
    char dequeue();
    int size();
    boolean isEmpty();
    boolean isFull();
}
