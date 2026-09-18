package edu.iastate.cs2280.hw1;

public class Empty extends TownCell {

    public Empty(Town p, int r, int c) {
        super(p,r,c);
    }

    @Override
    public State who() {
        return State.EMPTY;
    }

    @Override
    public TownCell next(Town tNew) {
        TownCell cell = new Casual(tNew, row, col);
        this.census(nCensus);
        if(nCensus[EMPTY]+nCensus[OUTAGE]<=1){
            cell = new Reseller(tNew, row, col);
        }
        return cell;
    }

    @Override
    public String toString(){
        return "E";
    }
}
