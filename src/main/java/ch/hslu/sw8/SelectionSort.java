package ch.hslu.sw8;

import ch.hslu.sw8.animation.SortingAnimation;

public class SelectionSort {

    public static int[] sort(int[] arr) {
        selectionSort(arr,false);
        return arr;
    }

    public static long selectionSort(int[] array, boolean enableGUI) {
        long numberOfComparisons = 0;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int minPosition = i;
            int min = array[minPosition];
            for (int j = i + 1; j < length; j++) {
                if (array[j] < min) {
                    minPosition = j;
                    min = array[minPosition];
                    if (enableGUI) {
                        SortingAnimation.instance().showArray(array, 200, j);
                    }
                }
                numberOfComparisons++;
            }
            if (minPosition != i) {
                array[minPosition] = array[i];
                array[i] = min;
                if (enableGUI) {
                    SortingAnimation.instance().showArray(array, 200, i);
                }
            }
        }
        return numberOfComparisons;
    }

    public static long[] measureSelectionSort(int[] array, int runs) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.currentTimeMillis();
            long comparisons = selectionSort(array,false);

            totalTime += (System.currentTimeMillis() - start);
            totalComparisons += comparisons;
        }

        return new long[]
                {totalTime / runs, totalComparisons / runs };
    }
}
