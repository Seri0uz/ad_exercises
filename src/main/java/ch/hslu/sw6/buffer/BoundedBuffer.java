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
package ch.hslu.sw6.buffer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;
    private int usedSize;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
        usedSize = 0;
    }

    @Override
    public void add(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
        }
        takeSema.release();
        usedSize++;
    }

    @Override
    public T remove() throws InterruptedException {
        takeSema.acquire();
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
        }
        putSema.release();
        usedSize--;
        return elem;
    }

    @Override
    public boolean add(T elem, long millis) throws InterruptedException {
        if (!putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            return false;
        }
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
        }
        usedSize++;
        takeSema.release();
        return true;
    }

    @Override
    public T remove(long millis) throws InterruptedException {
        T elem;
       if (!takeSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
           return null;
       }
        takeSema.acquire();
        synchronized (queue) {
            elem = queue.removeLast();
        }
        usedSize--;
        putSema.release();
        return elem;
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public boolean full() {
        return usedSize >= queue.size();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
