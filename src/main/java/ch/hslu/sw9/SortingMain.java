package ch.hslu.sw9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ch.hslu.sw8.BubbleSort.measureBubbleSort;
import static ch.hslu.sw8.BubbleSort.measureBubbleSort2;
import static ch.hslu.sw8.InsertionSort.measureInsertionSort;
import static ch.hslu.sw8.SelectionSort.measureSelectionSort;

public class SortingMain {

    static int[] n = {1_000_000,2_000_000,4_000_000};

    private static final Logger LOG = LoggerFactory.getLogger(SortingMain.class);
    /** 
     * Liefert ein Array mit den Zahlen 1 bis size in zufälliger Reihenfolge.
     * 
     * @param size die Anzahl der Zahlen
     * 
     */
    static int[] getShuffledNumbers(int size) {
        List<Integer> numbers = IntStream.range(1, size + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in aufsteigender Reihenfolge.
     * 
     * @param size die Anzahl der Zahlen
     */
    static int[] getAscendingNumbers(int size) {
        return IntStream.range(1, size + 1).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in absteigender Reihenfolge.
     * 
     * @param size die Anzahl der Zahlen
     */
    static int[] getDescendingNumbers(int size) {
        return IntStream.range(1, size + 1).map(i -> size - i + 1).toArray();
    }



    public static void main(String[] args) {
        //Quicksort.quickSort(getShuffledNumbers(50), 0, 49,true);
        //quickSort(5);

        //QuickInsertionSort.hybridQuickSort(getShuffledNumbers(100),0,99, true);
        quickInsertionSort(5);

        //Heapsort.heapsort(getShuffledNumbers(50));


    }

    private static void quickSort(int runs) {
        long totalTime = 0;
        long totalComparisons = 0;
            for (int i = 0; i < n.length; i++) {
                for (int j = 0; j < runs; j++) {
                    int[] numbers = getShuffledNumbers(n[i]);
                    long[] measure = Quicksort.measureQuicksort(numbers,0,n[i]-1, 1);
                    totalTime += measure[0];
                    totalComparisons += measure[1];
                }
                totalTime = totalTime/runs;
                totalComparisons = totalComparisons/runs;
                LOG.info("Shuffled Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}", n[i], totalTime, totalComparisons);
            }

    }

    private static void quickInsertionSort(int runs) {
        long totalTime = 0;
        long totalComparisons = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < runs; j++) {
                int[] numbers = getShuffledNumbers(n[i]);
                long[] measure = QuickInsertionSort.measureQuickInsertionSort(numbers,0,n[i]-1, 1);
                totalTime += measure[0];
                totalComparisons += measure[1];
            }
            totalTime = totalTime/runs;
            totalComparisons = totalComparisons/runs;
            LOG.info("Shuffled Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}", n[i], totalTime, totalComparisons);
        }

    }


}
