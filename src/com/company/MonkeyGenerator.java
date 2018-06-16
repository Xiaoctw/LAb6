package com.company;

import java.util.ArrayList;
import java.util.List;

public class MonkeyGenerator {
    /**
     * 用于生成ID
     */
    private int numberOfmonkeys=0;
    /**
     * 每隔t时间，产生k个猴子,时间t的控制留给主函数进行操作，即每隔t时间调用一个生成器函数
     */
   // private int t;
    private int k;
    private boolean mark;
    private int maxSpeed;
    public MonkeyGenerator( int k,int maxSpeed) {
        this.k = k;
        this.maxSpeed = maxSpeed;
    }
    public List<Monkey> makeMonkeys(){
        List<Monkey> res=new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            res.add(new Monkey(numberOfmonkeys,"",(int)(Math.random()*maxSpeed)));
        }
        return res;
    }
}
