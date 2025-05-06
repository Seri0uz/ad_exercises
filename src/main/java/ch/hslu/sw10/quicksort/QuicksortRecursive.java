/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw10.quicksort;


/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public final class QuicksortRecursive {

    /**
     * Privater Konstruktor.
     */
    private QuicksortRecursive() {
    }


    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param array input array.
     */
    public static void quicksort(int[] array) {
        QuicksortRecursive.hybridQuickSort(array, 0, array.length - 1);
    }


    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);

        return i + 1;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];

        array[i] = array[j];
        array[j] = temp;
    }

    public static void hybridQuickSort(int[] array, int start, int end) {
        int p;
        while (start < end) {
            if (end - start < 30) {
                insertionSort(array, start, end);
                break;
            } else {
                p = partition(array, start, end);

                if (p - start < p - end) {
                    hybridQuickSort(array, start, p - 1);
                    start = p + 1;
                } else {
                    hybridQuickSort(array, p + 1, end);
                    end = p - 1;
                }
            }
        }

    }

    private static void insertionSort(int[] array, int start, int end) {
        int element;
        int j;
        for (int i = start; i <= end; i++) {
            element = array[i];
            j = i;
            while ((j > 0) && (array[j - 1] > element)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = element;
        }
    }
}