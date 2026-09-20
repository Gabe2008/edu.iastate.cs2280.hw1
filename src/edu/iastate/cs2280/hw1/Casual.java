package edu.iastate.cs2280.hw1;

/**
 * @author Gabriel Vesperman
 */

public class Casual extends TownCell {

    public Casual(Town p, int r, int c) {
        super(p,r,c);
    }

    @Override
    public State who() {
        return State.CASUAL;
    }

    @Override
    public TownCell next(Town tNew) {
        TownCell cell = new Casual(tNew, row, col);
        this.census(nCensus);
        if(nCensus[RESELLER] > 0){
            cell = new Outage(tNew, row, col);
        } else if (nCensus[STREAMER] > 0) {
            cell = new Streamer(tNew, row, col);
        }
        if(nCensus[EMPTY]+nCensus[OUTAGE]<=1){
            cell = new Reseller(tNew, row, col);
        }
        if(cell.who() == this.who()&&nCensus[CASUAL]>=5) {
            cell = new Streamer(tNew, row, col);
        }
        return cell;
    }

    @Override
    public String toString(){
        return "C";
    }
}
