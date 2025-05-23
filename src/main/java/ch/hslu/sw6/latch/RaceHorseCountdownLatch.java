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

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

/**
 * Ein Rennpferd, das durch ein Startsignal losläuft. Nach einer zufälligen Zeit
 * kommt es im Ziel an.
 */
public final class RaceHorseCountdownLatch implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(RaceHorseCountdownLatch.class);
    private final CountDownLatch endSignal;
    private final String name;
    private final Random random;
    private final CountDownLatch startSignal;
    private final CountDownLatch inBoxSignal;

    /**
     * Erzeugt ein Rennpferd, das in die Starterbox eintritt.
     *
     * @param startSignal Starterbox.
     * @param name Name des Pferdes.
     */
    public RaceHorseCountdownLatch(final CountDownLatch startSignal, final String name, CountDownLatch inBoxSignal, CountDownLatch endSignal) {
        this.startSignal = startSignal;
        this.inBoxSignal = inBoxSignal;
        this.endSignal = endSignal;
        this.name = name;
        this.random = new Random();

    }

    @Override
    public void run() {
        LOG.info("Rennpferd {} geht in die Box.", name);
        inBoxSignal.countDown(); // Ensure all horses are at the start
        try {
            startSignal.await();
            LOG.info("Rennpferd {} laeuft los...", name);
            Thread.sleep(random.nextInt(3000));
            LOG.info("Rennpferd {} ist im Ziel.", name);
            endSignal.countDown();

        }
        catch (InterruptedException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
    }
}
