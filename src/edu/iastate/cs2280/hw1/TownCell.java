package edu.iastate.cs2280.hw1;

/**
 * 
 * @author Gabriel Vesperman
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		//TODO: Write your code here.
		for(int i = -1; i<=1; i++) {
			for(int j = -1; j<=1; j++) {
				if(i+row >= 0
						&& i+row < plain.getLength()
						&& j+col >= 0
						&& j+col < plain.getWidth()
						&& (i != 0 || j != 0)) {
					State state = plain.grid[i+row][j+col].who();

					if (state == State.RESELLER) {
						nCensus[RESELLER]++;
					}
					else if (state == State.EMPTY) {
						nCensus[EMPTY]++;
					}
					else if (state == State.CASUAL) {
						nCensus[CASUAL]++;
					}
					else if (state == State.OUTAGE) {
						nCensus[OUTAGE]++;
					}
					else if (state == State.STREAMER) {
						nCensus[STREAMER]++;
					}
				}
			}
		}

	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
