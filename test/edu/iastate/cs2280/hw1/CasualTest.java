package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CasualTest {

    @Test
    void who() {
        Town town = new Town(3, 3);
        Casual casual = new Casual(town, 1, 1);

        assertEquals(State.CASUAL, casual.who());
    }

    @Test
    void testToString() {
        Town town = new Town(3, 3);
        Casual casual = new Casual(town, 1, 1);
        assertEquals("C", casual.toString());
    }

    @Test
    void nextWithReseller() {
        Town town;
        try {
            town = new Town("ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[1][2].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.OUTAGE, nextCell.who());
    }

    @Test
    void nextWithStreamer() {
        Town town;
        try {
            town = new Town("CNWS4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[1][2].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.STREAMER, nextCell.who());
    }

    @Test
    void nextWithFewEmptyOutage() {
        Town town;
        try {
            town = new Town("Test1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[0][0].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.RESELLER, nextCell.who());
    }

    @Test
    void nextWithFiveCasual() {
        Town town;
        try {
            town = new Town("Test2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[1][1].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.STREAMER, nextCell.who());
    }

    @Test
    void nextUnchanged() {
        Town town;
        try {
            town = new Town("Test3.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[1][1].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.CASUAL, nextCell.who());
    }
}