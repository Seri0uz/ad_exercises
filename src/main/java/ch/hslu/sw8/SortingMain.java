package ch.hslu.sw8;

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

    static int[] n = {100_000,200_000,400_000};

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

        // InsertionSort.insertionSort(getShuffledNumbers(50),true);
        // insertionSort();

        // SelectionSort.selectionSort(getShuffledNumbers(50),true);
       //selectionSort();

        //BubbleSort.bubbleSort(getShuffledNumbers(50),true);
        //bubbleSort();

        //BubbleSort.bubbleSort2(getShuffledNumbers(50),true);
        //bubbleSort2();

    }

    private static void insertionSort() {
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getShuffledNumbers(n[i]);
            long[] measure = measureInsertionSort(numbers,5);
            LOG.info("Shuffled Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getAscendingNumbers(n[i]);
            long[] measure = measureInsertionSort(numbers,5);
            LOG.info("Ascending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getDescendingNumbers(n[i]);
            long[] measure = measureInsertionSort(numbers,5);
            LOG.info("Descending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
    }

    private static void selectionSort() {
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getShuffledNumbers(n[i]);
            long[] measure = measureSelectionSort(numbers,5);
            LOG.info("Shuffled Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i], measure[0], measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getAscendingNumbers(n[i]);
            long[] measure = measureSelectionSort(numbers,5);
            LOG.info("Ascending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getDescendingNumbers(n[i]);
            long[] measure = measureSelectionSort(numbers,5);
            LOG.info("Descending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
    }

    private static void bubbleSort() {
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getShuffledNumbers(n[i]);
            long[] measure = measureBubbleSort(numbers,5);
            LOG.info("Shuffled Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i], measure[0], measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getAscendingNumbers(n[i]);
            long[] measure = measureBubbleSort(numbers,5);
            LOG.info("Ascending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getDescendingNumbers(n[i]);
            long[] measure = measureBubbleSort(numbers,5);
            LOG.info("Descending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
    }

    private static void bubbleSort2() {
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getShuffledNumbers(n[i]);
            long[] measure = measureBubbleSort2(numbers,5);
            LOG.info("Shuffled Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i], measure[0], measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getAscendingNumbers(n[i]);
            long[] measure = measureBubbleSort2(numbers,5);
            LOG.info("Ascending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
        for (int i = 0; i < n.length; i++) {
            int[] numbers = getDescendingNumbers(n[i]);
            long[] measure = measureBubbleSort2(numbers,5);
            LOG.info("Descending Numbers:  Size: {}, Average Duration: {} ms, Comparisons: {}",n[i],measure[0],measure[1]);
        }
    }




}
