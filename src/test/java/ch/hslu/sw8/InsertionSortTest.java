package ch.hslu.sw8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ch.hslu.sw8.InsertionSort.insertionSort;
import static ch.hslu.sw8.InsertionSort.sort;
import static ch.hslu.sw8.SortingMain.getShuffledNumbers;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {


    @Test
    void testInsertionSortRandom() {
        int[] result = InsertionSort.sort(getShuffledNumbers(50));
        boolean isSorted = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != result.length && result[i] > result[i + 1]) {
                isSorted = false;
            }
        }
        assertTrue(isSorted);
    }

    @Test
    void testSelectionSortRandom() {
        int[] result = SelectionSort.sort(getShuffledNumbers(50));
        boolean isSorted = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != result.length && result[i] > result[i + 1]) {
                isSorted = false;
            }
        }
        assertTrue(isSorted);
    }

}