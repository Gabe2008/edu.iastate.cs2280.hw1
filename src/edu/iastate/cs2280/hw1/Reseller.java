package edu.iastate.cs2280.hw1;

public class Reseller extends TownCell {

    public Reseller(Town p, int r, int c) {
        super(p,r,c);
    }

    @Override
    public State who() {
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town tNew) {
        TownCell cell = new Reseller(tNew, row, col);
        this.census(nCensus);
        if(nCensus[CASUAL] <= 3){
            cell = new Empty(tNew, row, col);
        } else if (nCensus[EMPTY] >= 3) {
            cell = new Empty(tNew, row, col);
        }
        if(cell.who() == this.who()&&nCensus[CASUAL]>=5) {
            cell = new Streamer(tNew, row, col);
        }
        return cell;
    }

    @Override
    public String toString(){
        return "R";
    }
}
