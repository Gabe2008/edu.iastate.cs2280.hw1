package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gabriel Vesperman
 */

class ISPBusinessTest {

    /*@Test
    void mainFile() {
        String[] args = new String[] { "1", "ISP4x4.txt" };
        assertDoesNotThrow(() -> {
            ISPBusiness.main(args);
        });
    }

    @Test
    void mainRandom() {
        String[] args = new String[] { "2", "4 4 10" };
        assertDoesNotThrow(() -> {
            ISPBusiness.main(args);
        });
    }*/

    @Test
    void updatePlain() {
        Town town;
        try {
            town = new Town("ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }

        Town town2;
        try {
            town2 = new Town("ISP4x4_2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }

        Town nextTown = ISPBusiness.updatePlain(town);

        assertEquals(town2.toString(), nextTown.toString());
    }

    @Test
    void getProfit() {
        Town town;
        try {
            town = new Town("ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            fail("Required test file was not found", e);
            return;
        }

        assertEquals(1, ISPBusiness.getProfit(town));
    }
}