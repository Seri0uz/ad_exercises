package ch.hslu.sw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci {
    private static final Logger logger = LoggerFactory.getLogger(Fibonacci.class);

    public static int fiboRec1(int n) {
        //Rekursionsbasis
        if ((n == 0) || (n == 1)) {
            return n;
        }
        //Rekursionsvorschrift
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public static int fiboRec2(int n, int[] nSaved) {
        //Rekursionsbasis
        if ((n == 0) || (n == 1)) {
            return n;
        }
        //Rekursionsvorschrift
        int result=fiboRec2(n - 1,nSaved) + fiboRec2(n - 2, nSaved);
        nSaved[n]=result;
        return result ;

    }

    public static int fiboItr(int n) {
        int a = 0;
        int b = 0;
        int result = 1;
        for (int i=1; i<n; i++) {
            a = b;
            b = result;
            result = a+b;
        }
        return result;
    }

    public static void main(String[] args) {
        fiboRec1(13);

    }
}
