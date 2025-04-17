package ch.hslu.sw8;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ch.hslu.sw8.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertionSort {
    private static final Logger LOG = LoggerFactory.getLogger(InsertionSort.class);

    public static int[] sort(final int[] array) {
        insertionSort(array,false);
        return array;
    }

    public static long insertionSort(final int[] a, boolean enableGUI) {
        final long start = System.nanoTime();
        int element;
        int j;
        long numberOfComparisons = 0;
        for (int i = 1; i < a.length; i++) {
            element = a[i];
            j = i;
            while ((j > 0) && (a[j - 1] > element)) {
                a[j] = a[j - 1];
                j--;
                if(enableGUI) {
                    SortingAnimation.instance().showArray(a, 100, j);
                }
                numberOfComparisons++;
            }
            a[j] = element;
        }
        return numberOfComparisons;
    }

    public static long[] measureInsertionSort(final int[] a, final int runs) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.currentTimeMillis();
            long comparisons = insertionSort(a,false);

            totalTime += (System.currentTimeMillis() - start);
            totalComparisons += comparisons;
        }

        return new long[]
                {totalTime / runs, totalComparisons / runs };
    }

}
