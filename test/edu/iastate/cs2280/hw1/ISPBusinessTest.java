package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ISPBusinessTest {

    @Test
    void updatePlain() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        Town town2;
        try {
            town2 = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\ISP4x4_2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        Town nextTown = ISPBusiness.updatePlain(town);

        assertEquals(nextTown.toString(), town2.toString());
    }

    @Test
    void getProfit() {
        Town town;
        try {
            town = new Town("C:\\Users\\gabri\\Desktop\\edu.iastate.cs2280.hw1\\ISP4x4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        assertEquals(1, ISPBusiness.getProfit(town));
    }
}