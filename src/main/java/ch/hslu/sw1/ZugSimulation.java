package ch.hslu.sw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZugSimulation {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZugSimulation.class);

    public static void main(final String[] args) {
        Wagen wagen = new Wagen("W001", 60, new Wagen("W002", 60, new Wagen("W003", 50)));

        int totalPassengers = ZugInterface.calculateTotalSpace(wagen);
        LOGGER.info("Total Passengers : " + totalPassengers);
    }


}
