package com.company;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    /**
     * 代表梯子的长度
     */
    private int h;
    public int number;//梯子对应的编号
    protected boolean leftToRightFree=true;
    protected boolean rightToLeftFree=true;
    protected int numMonkey=0;//梯子上猴子的数量
    protected int minDis=0;//梯子上猴子距离起始岸最近的距离
    protected int maxSpeed=Integer.MAX_VALUE;//在这个梯子上行走的最大速度由最慢的猴子决定
    protected List<Monkey> monkeys=new ArrayList<>();//梯子上的猴子集合
    protected Monkey latestMonkey=null;//最新加入的monkey
    public Ladder(int h,int number) {
        this.h = h;
        this.number=number;
    }
    public void addMonkey(Monkey monkey){
        monkeys.add(monkey);
        latestMonkey=monkey;
        if (monkey.getV()<maxSpeed){
            maxSpeed=monkey.getV();
        }
    }
    public int getH() {
        return h;
    }

}
