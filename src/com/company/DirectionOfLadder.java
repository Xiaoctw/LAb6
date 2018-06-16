package com.company;

public class DirectionOfLadder {
    private Ladder ladder;
    private boolean direction;
    protected boolean isFree=true;
    protected DirectionOfLadder fightabout;
    public DirectionOfLadder(Ladder ladder, String direction) {
        this.ladder = ladder;
        if (direction.equals("L->R")){
            this.direction=true;
        }else {
            this.direction=false;
        }
    }

    public boolean isDirection() {
        return direction;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
