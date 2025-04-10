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
package ch.hslu.sw7.bank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration der Bankgeschäfte - Aufgabe 4 - N3_EX_WeiterführendeKonzepte.
 */
public final class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBankAccount() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final long start = System.currentTimeMillis();
        final ArrayList<BankAccount> source = new ArrayList<>();
        final ArrayList<BankAccount> target = new ArrayList<>();
        final int amount = 500_080;
        final int number = 50;
        for (int i = 0; i < number; i++) {
            source.add(new BankAccount(amount));
            target.add(new BankAccount());
        }
        final ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < number; i++) {
                executor.submit(new AccountTask(source.get(i),target.get(i),amount));
                executor.submit(new AccountTask(target.get(i),source.get(i),amount));
            }
        }
        catch (final Exception e) {
            LOG.error(e.getMessage());
        }
        finally {
            executor.shutdown();
        }

        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < number; i++) {
            LOG.info("source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
        }
        LOG.info("Time elapsed: {}ms",(System.currentTimeMillis() - start));
    }
}

