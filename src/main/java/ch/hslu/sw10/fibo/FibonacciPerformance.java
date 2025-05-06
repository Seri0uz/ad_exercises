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
package ch.hslu.sw10.fibo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Performance Vergleich der Fibonacci Implementationen.
 */
public final class FibonacciPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciPerformance.class);

    /**
     * Privater Konstruktor.
     */
    private FibonacciPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int n = 42;
        final int numbOfRounds = 5;
        final FibonacciTask task = new FibonacciTask(n);

        long result = 0, start, end, totalTimeTask = 0, totalTimeRec = 0, totalTimeIt = 0;

        LOG.info("fibo({}) start...", n);

        for (int i = 0; i < numbOfRounds; i++) {
           start = System.currentTimeMillis();
           result = task.invoke();
           end = System.currentTimeMillis();
           totalTimeTask += end - start;
        }
        LOG.info("Conc. recursive = {}", result);
        LOG.info("Conc. recursive : {} msec.", totalTimeTask / numbOfRounds);


        for(int i = 0 ; i < numbOfRounds ; i++) {
            start = System.currentTimeMillis();
            result = FibonacciCalc.fiboIterative(n);
            end = System.currentTimeMillis();
            totalTimeIt += end - start;
        }
        LOG.info("Func. iterative = {}", result);
        LOG.info("Func. iterative : {} msec.", totalTimeIt / numbOfRounds);


        for(int i = 0 ; i < numbOfRounds ; i++) {
            start = System.currentTimeMillis();
            result = FibonacciCalc.fiboRecursive(n);
            end = System.currentTimeMillis();
            totalTimeRec += end - start;
        }
        LOG.info("Func. recursive = {}", result);
        LOG.info("Func. recursive : {} msec.", totalTimeRec / numbOfRounds);
    }
}
