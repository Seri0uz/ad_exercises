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
package ch.hslu.sw10.mergesort;

import ch.hslu.sw10.init.RandomInitTask;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Performance Vergleich der Mergesort Implementationen.
 */
public final class MergesortPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(MergesortPerformance.class);

    /**
     * Privater Konstruktor.
     */
    private MergesortPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 400_000_000;
        final int[] threshold = {10,60,600,6000,60000,600000,6000000};
        final int numbOfRuns = 5;
        long start, end, totalTimeRec = 0, totalTimeConc = 0, totalTimeSort = 0;

        final int[] arrayOriginal = new int[size];

        try (final ForkJoinPool pool = new ForkJoinPool()) {
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);
            int[] array;
            for (int t : threshold) {
               totalTimeConc = 0;
               for (int i = 0; i < numbOfRuns; i++) {
                   array = Arrays.copyOf(arrayOriginal, size);
                   start = System.currentTimeMillis();
                   final MergesortTask sortTask = new MergesortTask(array,t);
                   pool.invoke(sortTask);
                   end = System.currentTimeMillis();
                   totalTimeConc += (end - start);
               }
               LOG.info("Conc. Mergesort with Threshold {}: {} msec.",t, totalTimeConc / numbOfRuns);
           }

            for (int i = 0; i < numbOfRuns; i++) {
                array = Arrays.copyOf(arrayOriginal, size);

                start = System.currentTimeMillis();
                MergesortRecursive.mergeSort(array);
                end = System.currentTimeMillis();
                totalTimeRec += (end - start);
            }
            LOG.info("MergesortRec.   : {} msec.", totalTimeRec / numbOfRuns);

            for (int i = 0; i < numbOfRuns; i++) {
                array = Arrays.copyOf(arrayOriginal, size);
                start = System.currentTimeMillis();
                Arrays.parallelSort(array);
                end = System.currentTimeMillis();
                totalTimeSort += (end - start);
            }
            LOG.info("ParallelSort    : {} msec.", totalTimeSort / numbOfRuns);

        } finally {
            // Executor shutdown
        }
    }
}
