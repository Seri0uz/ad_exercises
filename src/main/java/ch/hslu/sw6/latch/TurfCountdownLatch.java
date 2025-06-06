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
package ch.hslu.sw6.latch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class TurfCountdownLatch {

    private static final Logger LOG = LoggerFactory.getLogger(TurfCountdownLatch.class);
    private static final int HORSES = 5;

    /**
     * Privater Konstruktor.
     */
    private TurfCountdownLatch() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch inBoxSignal = new CountDownLatch(HORSES);
        final CountDownLatch endSignal = new CountDownLatch(HORSES);

        for (int i = 1; i <= HORSES; i++) {
            Thread.startVirtualThread(new RaceHorseCountdownLatch(startSignal, "Horse " + i,inBoxSignal,endSignal));
        }
        inBoxSignal.await();
        LOG.info("Start...");
        startSignal.countDown();

        try {
            endSignal.await(); // Wait for all horses to finish
            LOG.info("Race finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

