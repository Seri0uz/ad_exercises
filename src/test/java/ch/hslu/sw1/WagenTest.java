package ch.hslu.sw1;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WagenTest {
    private Wagen wagon1;
    private Wagen wagon2;
    private Wagen wagon3;

    @BeforeEach
    void setUp() {
        wagon3 = new Wagen("W003", 80);
        wagon2 = new Wagen("W002", 40, wagon3);
        wagon1 = new Wagen("W001", 60, wagon2);
    }

    @Test
    void testGetName() {
        assertEquals("W001", wagon1.getName());
    }

    @Test
    void testGetSpace() {
        assertEquals(60, wagon1.getSpace());
    }

    @Test
    void testGetNextWagen() {
        assertEquals(wagon2, wagon1.getNextWagen());
    }

    @Test
    void testCalculateTotalPassengers() {
        assertEquals(180,ZugInterface.calculateTotalSpace(wagon1));
    }

    @Test
    void testEqualsAndHashCode() {
        EqualsVerifier.simple().forClass(Wagen.class).withIgnoredFields("nextWagen").withPrefabValues(Wagen.class, new Wagen("X001", 10), new Wagen("X002", 20)).verify();
    }



}