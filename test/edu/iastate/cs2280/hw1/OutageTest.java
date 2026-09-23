package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gabriel Vesperman
 */

class OutageTest {

    @Test
    void who() {
        Town town = new Town(3, 3);
        Outage cell = new Outage(town, 1, 1);

        assertEquals(State.OUTAGE, cell.who());
    }

    @Test
    void next() {
        Town town = new Town(3, 3);
        Outage cell = new Outage(town, 1, 1);

        assertEquals(State.EMPTY, cell.next(new Town(town.getLength(), town.getWidth())).who());
    }

    @Test
    void testToString() {
        Town town = new Town(3, 3);
        Outage cell = new Outage(town, 1, 1);
        assertEquals("O", cell.toString());
    }
}