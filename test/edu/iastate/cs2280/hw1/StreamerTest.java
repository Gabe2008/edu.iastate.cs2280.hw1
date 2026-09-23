package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gabriel Vesperman
 */

class StreamerTest {

    @Test
    void who() {
        Town town = new Town(3, 3);
        Streamer cell = new Streamer(town, 1, 1);

        assertEquals(State.STREAMER, cell.who());
    }

    @Test
    void testToString() {
        Town town = new Town(3, 3);
        Streamer cell = new Streamer(town, 1, 1);
        assertEquals("S", cell.toString());
    }

    @Test
    void nextWithReseller() {
        Town town;
        try {
            town = new Town("Streamer6x6.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }
        TownCell nextCell = town.grid[1][1].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.OUTAGE, nextCell.who());
    }

    @Test
    void nextWithOutage() {
        Town town;
        try {
            town = new Town("Streamer6x6.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }
        TownCell nextCell = town.grid[1][4].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.EMPTY, nextCell.who());
    }

    @Test
    void nextWithFewEmptyOutage() {
        Town town;
        try {
            town = new Town("Streamer6x6.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }
        TownCell nextCell = town.grid[4][1].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.RESELLER, nextCell.who());
    }

    @Test
    void nextWithFiveCasual() {
        Town town;
        try {
            town = new Town("Streamer6x6.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }
        TownCell nextCell = town.grid[4][4].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.STREAMER, nextCell.who());
    }

    @Test
    void nextUnchanged() {
        Town town;
        try {
            town = new Town("Streamer3x3.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }
        TownCell nextCell = town.grid[1][1].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.STREAMER, nextCell.who());
    }
}