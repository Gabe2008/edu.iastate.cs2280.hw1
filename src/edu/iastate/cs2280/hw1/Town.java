package edu.iastate.cs2280.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Gabriel Vesperman
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		//TODO: Write your code here.
		this.length = Math.abs(length);
		this.width = Math.abs(width);
		grid = new TownCell[this.length][this.width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		//TODO: Write your code here.
		Scanner sc = new Scanner(new File(inputFileName));
		try {
			length = sc.nextInt();
			width = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Grid dimensions not formatted correctly.");
			sc.close();
			return;
		}
		grid = new TownCell[length][width];

		for(int row = 0; row < length; row++){
			for(int col = 0; col < width; col++){
				char cell;
				try {
					cell = sc.next().charAt(0);
				} catch (InputMismatchException e) {
					System.out.println("Grid not formatted correctly.");
					sc.close();
					return;
				}
				if (cell == 'C'){
					grid[row][col] = new Casual(this ,row, col);
				}
				if (cell == 'E'){
					grid[row][col] = new Empty(this ,row, col);
				}
				if (cell == 'O'){
					grid[row][col] = new Outage(this ,row, col);
				}
				if (cell == 'R'){
					grid[row][col] = new Reseller(this ,row, col);
				}
				if (cell == 'S'){
					grid[row][col] = new Streamer(this ,row, col);
				}
			}
		}

		sc.close();
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		//TODO: Write/update your code here.
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		//TODO: Write/update your code here.
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		//TODO: Write your code here.
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				int type = rand.nextInt(5);
				if (type == TownCell.CASUAL){
					grid[i][j] = new Casual(this, i, j);
				} else
				if (type == TownCell.STREAMER){
					grid[i][j] = new Streamer(this, i, j);
				} else
				if (type == TownCell.RESELLER){
					grid[i][j] = new Reseller(this, i, j);
				} else
				if (type == TownCell.EMPTY){
					grid[i][j] = new Empty(this, i, j);
				} else
				if (type == TownCell.OUTAGE){
					grid[i][j] = new Outage(this, i, j);
				} else {
					grid[i][j] = new Empty(this, i, j);
					System.out.println("Fix random number");
				}
			}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		//TODO: Write your code here.
		for(TownCell[] row: grid){
			for(TownCell cell: row){
				s+= cell.toString()+" ";
			}
			s+= "\n";
		}

		return s;
	}
}
