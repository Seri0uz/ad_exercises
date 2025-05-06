package ch.hslu.sw9;


import ch.hslu.sw9.animation.SortingAnimation;



public class QuickInsertionSort {

    private static long numberOfComparisons = 0;

    private static int partition(int[] array, int start, int end, boolean enableGUI) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j, enableGUI);
            }
        }
        swap(array, i + 1, end, enableGUI);
        if (enableGUI) {
            SortingAnimation.instance().showArray(array, 100, i);
        }
        return i + 1;

    }

    private static void swap(int[] array, int i, int j, boolean enableGUI) {
        int temp = array[i];

        array[i] = array[j];
        array[j] = temp;
        if (enableGUI) {
            SortingAnimation.instance().showArray(array, 100, i);
        }
        numberOfComparisons++;

    }

    public static void hybridQuickSort(int[] array, int start, int end, boolean enableGUI) {
        int p;
        while (start < end) {
            if (end - start < 30) {
                insertionSort(array, start, end, enableGUI);
                break;
            }
            else {
                p = partition(array, start, end, enableGUI);

                if (p - start < p - end) {
                    hybridQuickSort(array, start, p - 1, enableGUI);
                    start = p + 1;
                }
                else {
                    hybridQuickSort(array, p + 1, end, enableGUI);
                    end = p - 1;
                }
            }
        }

    }

    private static long insertionSort(int[] array, int start, int end, boolean enableGUI) {
        int element;
        int j;
        for (int i = start; i <= end; i++) {
            numberOfComparisons++;
            element = array[i];
            j = i;
            while ((j > 0) && (array[j - 1] > element)) {
                array[j] = array[j - 1];
                j--;
                if (enableGUI) {
                    SortingAnimation.instance().showArray(array, 100, j);
                }
                numberOfComparisons++;
            }
            array[j] = element;
        }
        return numberOfComparisons;
    }

    public static long[] measureQuickInsertionSort(int[] array, int start, int end, int runs) {
        long totalTime = 0;
        long startTime = System.currentTimeMillis();

        hybridQuickSort(array, start, end, false);

        totalTime += (System.currentTimeMillis() - startTime);

        return new long[]
                {totalTime, numberOfComparisons};

    }

}
