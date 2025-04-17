package ch.hslu.sw8;

import ch.hslu.sw8.animation.SortingAnimation;

public class BubbleSort {

    public static int[] sort(int[] array) {
        bubbleSort(array,false);
        return array;
    }

    public static long bubbleSort(int[] array, boolean enableGUI) {
        long numberOfComparisons = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                if (enableGUI) {
                    SortingAnimation.instance().showArray(array, 50, j+1);
                }
                numberOfComparisons++;
            }
            if (enableGUI) {
                SortingAnimation.instance().showArray(array, 100, i+1);
            }
        }
        return numberOfComparisons;
    }

    public static long bubbleSort2(int[] array, boolean enableGUI) {
        long numberOfComparisons = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                if (enableGUI) {
                    SortingAnimation.instance().showArray(array, 50, j+1);
                }
                numberOfComparisons++;
            }
            if (!swapped) {
                break;
            }
        }
        return numberOfComparisons;
    }

    public static long[] measureBubbleSort(int[] array, int runs) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.currentTimeMillis();
            long comparisons = bubbleSort(array,false);

            totalTime += (System.currentTimeMillis() - start);
            totalComparisons += comparisons;
        }

        return new long[]
                {totalTime / runs, totalComparisons / runs };
    }

    public static long[] measureBubbleSort2(int[] array, int runs) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.currentTimeMillis();
            long comparisons = bubbleSort2(array,false);

            totalTime += (System.currentTimeMillis() - start);
            totalComparisons += comparisons;
        }

        return new long[]
                {totalTime / runs, totalComparisons / runs };
    }

}
