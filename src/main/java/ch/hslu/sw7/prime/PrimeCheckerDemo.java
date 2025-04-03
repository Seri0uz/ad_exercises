package ch.hslu.sw7.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeCheckerDemo {
    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheckerDemo.class);
    private static final int MAX_PRIME = 100;

    public PrimeCheckerDemo() {

    }

    public static void main(String[] args) {
        try {
            final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
            List<Future<BigInteger>> results = new ArrayList<>();
            for (int i = 0; i < MAX_PRIME; i++) {
                results.add(executor.submit(new PrimeChecker()));
            }
        }
        catch(IllegalArgumentException e) {

        }

    }
}
