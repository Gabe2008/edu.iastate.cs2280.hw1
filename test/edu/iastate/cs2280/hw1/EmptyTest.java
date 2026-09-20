package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EmptyTest {

    @Test
    void who() {
        Town town = new Town(3, 3);
        Empty empty = new Empty(town, 1, 1);

        assertEquals(State.EMPTY, empty.who());
    }

    @Test
    void nextWithFewEmptyOutage() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\Test1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[1][4].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.RESELLER, nextCell.who());
    }

    @Test
    void nextUnchanged() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\Test3.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[1][4].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.CASUAL, nextCell.who());
    }

    @Test
    void testToString() {
        Town town = new Town(3, 3);
        Empty empty = new Empty(town, 1, 1);
        assertEquals("E", empty.toString());
    }
}