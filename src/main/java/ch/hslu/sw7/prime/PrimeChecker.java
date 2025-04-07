package ch.hslu.sw7.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeChecker implements Callable<BigInteger> {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeChecker.class);

    private BigInteger candidate;

    public PrimeChecker() {
        candidate = bigInteger();
    }

    private static BigInteger bigInteger() {
        return new BigInteger(1024, new Random());
    }

    @Override
    public BigInteger call() throws Exception {
       while (!candidate.isProbablePrime(Integer.MAX_VALUE)) {
           candidate = bigInteger();
       }
       LOG.info("Prime is {}", candidate);
        return candidate;
    }
}
