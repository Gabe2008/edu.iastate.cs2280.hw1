package edu.iastate.cs2280.hw1;

public class Outage extends TownCell {

    public Outage(Town p, int r, int c) {
        super(p,r,c);
    }

    @Override
    public State who() {
        return State.OUTAGE;
    }

    @Override
    public TownCell next(Town tNew) {
        TownCell cell = new Empty(tNew, row, col);
        return cell;
    }

    @Override
    public String toString(){
        return "O";
    }
}
