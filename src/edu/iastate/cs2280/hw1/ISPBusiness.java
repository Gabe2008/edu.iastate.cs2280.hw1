package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Gabriel Vesperman
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//TODO: Write your code here.
		for (int i = 0; i < tOld.getLength(); i++) {
			for (int j = 0; j < tOld.getWidth(); j++) {
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		//TODO: Write/update your code here.
		int profit = 0;
		for(int i = 0; i<town.getLength(); i++) {
			for(int j = 0; j<town.getWidth(); j++) {
				if(town.grid[i][j].who() == State.CASUAL){
					profit+=1;
				}
			}
		}
		return profit;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		//TODO: Write your code here.
		Town town;

		Scanner sc = new Scanner(System.in);
		System.out.println("1 - File\n2 - Random");
		int option1;
		try{
			option1 = sc.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Invalid Input");
			sc.close();
			return;
		}
		if(option1==1){
			System.out.println("File path:");
			try {
				town = new Town(sc.next());
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				sc.close();
				return;
			}
		} else {
			System.out.println("Rows Cols Seed");
			try {
				int rows = sc.nextInt();
				int cols = sc.nextInt();
				int seed = sc.nextInt();
				town = new Town(rows, cols);
				town.randomInit(seed);
			} catch(InputMismatchException e) {
				System.out.println("Wrong input format.");
				sc.close();
				return;
			}
		}
		sc.close();
		int profit = 0;

		for(int i = 0; i<12; i++) {
			town = updatePlain(town);
			profit+=getProfit(town);
		}

		double maxProfit = town.getLength() * town.getWidth() * 12.0;
		double profitPercentage = 100.0 * profit / maxProfit;

		System.out.printf("%.2f%%%n", profitPercentage);
		return;
	}
}
