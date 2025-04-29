package ch.hslu.sw9;

import ch.hslu.sw9.animation.SortingAnimation;

public class Heapsort {

    static void heapify (int[] array, int n, int i) {
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }

    }

    static void heapsort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = array[i];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);

            SortingAnimation.instance().showArray(array, 100, temp);
        }


    }
}
