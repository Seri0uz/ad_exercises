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

import ch.hslu.sw10.init.RandomInitTask;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.sw10.sort.SortTask;
import ch.hslu.sw10.sort.check.SortCheckTask;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LoggerFactory.getLogger(DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 900_000;
        final int numbOfRounds = 5;
        final int[] arrayOriginal = new int[size];

        try (final ForkJoinPool pool = new ForkJoinPool()) {
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);

            long start, end, totalTimeTask = 0, totalTimeRec = 0, totalTimeSort = 0;

           for (int i = 0; i < numbOfRounds; i++) {
               int[] arrayTask = Arrays.copyOf(arrayOriginal, size);
               start = System.currentTimeMillis();
               final QuicksortTask sortTask = new QuicksortTask(arrayTask);
               pool.invoke(sortTask);
               end = System.currentTimeMillis();
               totalTimeTask += end - start;
               //SortCheckTask sort = new SortCheckTask(arrayTask);
               //boolean isSorted = sort.invoke();
               //LOG.info("Ist sortiert: {}",isSorted);
           }

           LOG.info("QuicksortTask  : {} ms.",totalTimeTask/numbOfRounds);

            for (int i = 0; i < numbOfRounds; i++) {
                int[] arrayRec = Arrays.copyOf(arrayOriginal, size);
                start = System.currentTimeMillis();
                QuicksortRecursive.quicksort(arrayRec);
                end = System.currentTimeMillis();
                totalTimeRec += end - start;
            }
            LOG.info("QuicksortRec.  : {} ms.", totalTimeRec/numbOfRounds);

            for (int i = 0; i < numbOfRounds; i++) {
                int[] arraySort = Arrays.copyOf(arrayOriginal, size);
                start = System.currentTimeMillis();
                Arrays.sort(arraySort);
                end = System.currentTimeMillis();
                totalTimeSort += end - start;
            }
            LOG.info("Arrays.sort    : {} ms.", totalTimeSort/numbOfRounds);
        } finally {
            // Executor shutdown
        }

    }
}
