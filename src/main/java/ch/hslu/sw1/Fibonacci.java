package ch.hslu.sw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci {
    private static final Logger logger = LoggerFactory.getLogger(Fibonacci.class);

    public static int fiboRec1(int n) {
        //Rekursionsbasis
        if ((n == 0) || (n == 1)) {
            return 1;
        }

        //Rekursionsvorschrift
        logger.info("Fibonacci number: " + n);
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public static void main(String[] args) {
        fiboRec1(13);

    }
}
