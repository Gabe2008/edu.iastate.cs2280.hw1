package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ResellerTest {

    @Test
    void who() {
        Town town = new Town(3, 3);
        Reseller cell = new Reseller(town, 1, 1);

        assertEquals(State.RESELLER, cell.who());
    }

    @Test
    void nextWithLessThanFourCasual() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\Test2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[8][7].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.EMPTY, nextCell.who());
    }

    @Test
    void nextWithThreeOrMoreEmpty() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\Test2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[8][4].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.EMPTY, nextCell.who());
    }

    @Test
    void nextWithFiveCasual() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\Test2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        TownCell nextCell = town.grid[8][1].next(new Town(town.getLength(), town.getWidth()));

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

        TownCell nextCell = town.grid[8][1].next(new Town(town.getLength(), town.getWidth()));

        assertEquals(State.RESELLER, nextCell.who());
    }

    @Test
    void testToString() {
        Town town = new Town(3, 3);
        Reseller cell = new Reseller(town, 1, 1);
        assertEquals("R", cell.toString());
    }
}