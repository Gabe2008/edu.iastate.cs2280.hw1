package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gabriel Vesperman
 */

class TownCellTest {

    @Test
    void census() {
        Town town;
        try {
            town = new Town("ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }

        TownCell cell = town.grid[1][1];
        int[] nCensus = new int[TownCell.NUM_CELL_TYPE];

        cell.census(nCensus);

        assertEquals(1, nCensus[TownCell.RESELLER]);
        assertEquals(2, nCensus[TownCell.EMPTY]);
        assertEquals(1, nCensus[TownCell.CASUAL]);
        assertEquals(3, nCensus[TownCell.OUTAGE]);
        assertEquals(1, nCensus[TownCell.STREAMER]);
    }
}