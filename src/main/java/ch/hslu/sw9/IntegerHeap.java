package ch.hslu.sw9;

public interface IntegerHeap {
    int extractMax();

    void swap(int i, int j);

    void insert(int value);

    boolean isEmpty();

    int parent(int i);

    int leftChild(int i);

    int rightChild(int i);



}
