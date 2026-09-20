package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TownTest {

    @Test
    void getWidth() {
        Town t = new Town(3,4);
        assertEquals(4,t.getWidth());
    }

    @Test
    void getLength() {
        Town t = new Town(3,4);
        assertEquals(3,t.getLength());
    }

    @Test
    void randomInit() {
        Town t = new Town(4, 4);
        t.randomInit(10);

        assertEquals(State.OUTAGE, t.grid[0][0].who());
        assertEquals(State.RESELLER, t.grid[0][1].who());
        assertEquals(State.OUTAGE, t.grid[0][2].who());
        assertEquals(State.RESELLER, t.grid[0][3].who());

        assertEquals(State.EMPTY, t.grid[1][0].who());
        assertEquals(State.EMPTY, t.grid[1][1].who());
        assertEquals(State.CASUAL, t.grid[1][2].who());
        assertEquals(State.OUTAGE, t.grid[1][3].who());

        assertEquals(State.EMPTY, t.grid[2][0].who());
        assertEquals(State.STREAMER, t.grid[2][1].who());
        assertEquals(State.OUTAGE, t.grid[2][2].who());
        assertEquals(State.STREAMER, t.grid[2][3].who());

        assertEquals(State.EMPTY, t.grid[3][0].who());
        assertEquals(State.OUTAGE, t.grid[3][1].who());
        assertEquals(State.RESELLER, t.grid[3][2].who());
        assertEquals(State.RESELLER, t.grid[3][3].who());
    }

    @Test
    void testToString() {
        Town town;
        try {
            town = new Town("ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        String expected =
                "O R O R \n" +
                "E E C O \n" +
                "E S O S \n" +
                "E O R R \n";
        assertEquals(town.toString(), expected);
    }
}