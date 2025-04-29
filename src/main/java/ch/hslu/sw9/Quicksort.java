package ch.hslu.sw9;

import ch.hslu.sw8.animation.SortingAnimation;

public class Quicksort {
    private static long numberOfComparisons = 0;

    private static int partition(int[] array, int start, int end, boolean enableGUI) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array,i,j,enableGUI);
            }
        }
        swap(array,i+1,end,enableGUI);
        if (enableGUI) {
            SortingAnimation.instance().showArray(array, 100, i);
        }
        return i+1;

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

    public static void quickSort(int[] array, int start, int end, boolean enableGUI) {
        int p;

        if (start < end) {
            p = partition(array, start, end, enableGUI);

            quickSort(array, start, p - 1, enableGUI);
            quickSort(array, p + 1, end,enableGUI);
        }
    }

    public static long[] measureQuicksort(int[] array,int start,int end, int runs) {
        long totalTime = 0;
        long startTime = System.currentTimeMillis();

        quickSort(array,start,end,false);

        totalTime += (System.currentTimeMillis() - startTime);

        return new long[]
                {totalTime, numberOfComparisons};

    }

}
