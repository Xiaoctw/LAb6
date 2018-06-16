package com.company;

public class MoveStatus implements Status {
    /**
     * 所在梯子
     */
    private int numLadder;
    /**
     * 所在第几号踏板
     */
    private int pedal;
    /**
     *这个是指距离出生已经经过了多长时间
     */
    private int birthTime;

    public int getNumLadder() {
        return numLadder;
    }

    public void setNumLadder(int numLadder) {
        this.numLadder = numLadder;
    }

    public int getPedal() {
        return pedal;
    }

    public void setPedal(int pedal) {
        this.pedal = pedal;
    }

    public int getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(int birthTime) {
        this.birthTime = birthTime;
    }
}
