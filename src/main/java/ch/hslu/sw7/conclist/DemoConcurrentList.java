/*
 * Copyright 2025 Hochschule Luzern - Informatik.
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
package ch.hslu.sw7.conclist;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration einer synchrnisierten List mit n Producer und m Consumer.
 */
public final class DemoConcurrentList {

    private static final Logger LOG = LoggerFactory.getLogger(DemoConcurrentList.class);

    /**
     * Privater Konstruktor.
     */
    private DemoConcurrentList() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException bei Excecution-Fehler.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {
        final long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new LinkedList<>();
        final List<Integer> synclist = Collections.synchronizedList(list);
        final List<Future<Long>> futures = new ArrayList<>();
        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 3; i++) {
                futures.add(executor.submit(new Producer(synclist, random.nextInt(1_000))));
            }
            Iterator<Future<Long>> iterator = futures.iterator();
            long totProd = 0;
            while (iterator.hasNext()) {
                long sum = iterator.next().get();
                totProd += sum;
                LOG.info("prod sum = {}" ,sum);
            }
            LOG.info("prod tot = {}" ,totProd);
            long totCons = executor.submit(new Consumer(synclist)).get();
            LOG.info("cons tot = {}" ,totCons);
            LOG.info("Time used: {}ms", (System.currentTimeMillis() - start));
        }
    }
}
