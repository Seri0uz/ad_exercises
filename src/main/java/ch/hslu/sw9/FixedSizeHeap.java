package ch.hslu.sw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FixedSizeHeap implements IntegerHeap {
    private ArrayList<Integer> heap;
    int size;

    public FixedSizeHeap(int space) {
        heap = new ArrayList<>(space);
        size = space;
    }

    @Override
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap.get(0);

        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);

            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);

                int largest = currentIndex;

                if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                    largest = left;
                }

                if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                    largest = right;
                }

                if (largest == currentIndex) {
                    break;
                }

                swap(currentIndex, largest);
                currentIndex = largest;
            }
        }
        return max;
    }

    @Override
    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public void insert(int value) {
        if (heap.size() > size - 1) {
            throw new RuntimeException("Heap is full");
        }
        heap.add(value);

        int currentIndex = heap.size() - 1;

        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));

            currentIndex = parent(currentIndex);
        }
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int parent(int i) {
        // middle term
        return (i -1) / 2;
    }

    @Override
    public int leftChild(int i) {
        return 2 * i + 1;
    }

    @Override
    public int rightChild(int i) {
        return 2*i + 2;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap.toArray());
    }
}
