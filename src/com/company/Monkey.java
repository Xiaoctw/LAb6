package com.company;

public class Monkey {
    private int ID;
    private String direction;//两种可能，分别为“L->R”或者“R->L”
    private int v;
    private long absolutetime1 ;
    private long absolutetime2;
    private long absolutetime=0;
    /**
     * 初始状态为等待状态，设置出生时间为0s
     */
    protected MonkeyStatus status=null;
    public Monkey(int ID, String direction, int v) {
        this.ID = ID;
        this.direction = direction;
        this.v = v;
        this.absolutetime1=System.currentTimeMillis();
        status=new MonkeyStatus();
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public long getAbsolutetime1() {
        return absolutetime1;
    }

    public long getAbsolutetime2() {
        return absolutetime2;
    }

    public void setAbsolutetime1(long absolutetime1) {
        this.absolutetime1 = absolutetime1;
    }

    public void setAbsolutetime2(long absolutetime2) {
        this.absolutetime2 = absolutetime2;
        absolutetime=this.absolutetime2-this.absolutetime1;
    }
}
