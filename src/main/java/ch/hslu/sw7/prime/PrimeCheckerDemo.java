package ch.hslu.sw7.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeCheckerDemo {
    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheckerDemo.class);
    private static final int MAX_PRIME = 100;

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() +1);
        try {
            List<Future<BigInteger>> results = new ArrayList<>();
            for (int i = 0; i < MAX_PRIME; i++) {
                results.add(executor.submit(new PrimeChecker()));
            }
            int i = 0;
            for (Future<BigInteger> prime : results) {
                i++;
                if (prime != null) {
                    LOG.info("{} : {}...",i,prime.get().toString().substring(0, 20));
                }
            }
        }
        catch(IllegalArgumentException | ExecutionException e) {
            LOG.error("{}",e.getMessage());
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOG.error("{}",e.getMessage());
        }
        finally {
            LOG.info("Time needed for calculation: {}ms",(System.currentTimeMillis()-start));
            LOG.info("Shutting down");
            executor.close();
        }


    }
}
