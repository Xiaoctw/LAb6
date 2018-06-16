package com.company;

public class WaitStatus implements Status {
//    public void comeToBridge(){
//
//    }
    /**
     * 距离出生的时间
     */
    private int birthTime;

    public WaitStatus(int birthTime) {
        this.birthTime = birthTime;
    }

    public int getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(int birthTime) {
        this.birthTime = birthTime;
    }
}
