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
package ch.hslu.sw10.findfile;

import java.io.File;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Codevorlage zu CountedCompleter für eine Dateisuche.
 */
@SuppressWarnings("serial")
public final class FindFileTask extends CountedCompleter<String> {

    /**
     * Name des gesuchten Files.
     */
    private final String regex;
    /**
     * Verzeichnis, des gesuchten Files.
     */
    private final File dir;
    /**
     * Referenz auf das gesuchte File mit Verzeichnis.
     */
    private final AtomicReference<String> result;

    /**
     * Erzeugt eine File-Such-Aufgabe.
     *
     * @param regex Ausdruck der den Filenamen enthält.
     * @param dir Verzeichnis in dem das File gesucht wird.
     */
    public FindFileTask(String regex, File dir) {
        this(null, regex, dir, new AtomicReference<>(null));
    }

    private FindFileTask(final CountedCompleter<?> parent, final String regex, final File dir,
            final AtomicReference<String> result) {
        super(parent);
        this.regex = regex;
        this.dir = dir;
        this.result = result;
    }

    @Override
    public void compute() {
        final File[] files = dir.listFiles();

        if (files == null) {
            tryComplete();
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                addToPendingCount(1);
                new FindFileTask(this, regex, file, result).fork(); // parallel
            }
            else if (regex.equalsIgnoreCase(file.getName())) {
                if (result.compareAndSet(null, file.getParent())) {
                    quietlyCompleteRoot(); // beende die Suche
                }
                return;
            }
        }
    }


    @Override
    public String getRawResult() {
        if (result != null) {
            return result.get();
        }
        return null;
    }
}
