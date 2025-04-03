package ch.hslu.sw7.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeChecker implements Callable<BigInteger> {


    public PrimeChecker() {

    }

    private static BigInteger bigInteger() {
        return new BigInteger(1024, new Random());
    }

    @Override
    public BigInteger call() {
        return bigInteger(); // anpassen
    }
}
