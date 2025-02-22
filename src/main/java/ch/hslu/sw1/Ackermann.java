package ch.hslu.sw1;

import java.util.logging.Logger;

public class Ackermann {
    static Logger log = Logger.getLogger("Ackermann");
    private static int programcounter=0;

    public static int ack(int m, int n) {
        programcounter++;
        if (m == 0)
        {
            log.info("Fall 1 m: " + m + " n: " + n);
            return n + 1;
        }
        else if((m > 0) && (n == 0))
        {
            log.info("Fall 2 m: " + m + " n: " + n);
            return ack(m - 1, 1);
        }
        else if((m > 0) && (n > 0))
        {
            log.info("Fall 3 m: " + m + " n: " + n);
            return ack(m - 1, ack(m, n - 1));
        }else
            log.info("Fall 4 m: " + m + " n: " + n);
            return n + 1;
    }

    public static void main(String args[])
    {
        System.out.println(ack(2, 2));
        log.info("Program counter: " + programcounter);
    }
}
