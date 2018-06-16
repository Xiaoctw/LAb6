package com.company;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MonkeyGeneratorTest {
    List<Monkey> monkeys=null;
    List<Ladder> ladders=null;
    List<DirectionOfLadder> directionOfLadders=null;
    @org.junit.Before
    public void setUp() throws Exception {
        monkeys=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            monkeys.add(new Monkey(i,"L->R",3));
        }
        for (int i = 10; i <20 ; i++) {
            monkeys.add(new Monkey(i,"R->L",2));
        }
        ladders=new ArrayList<>();
        directionOfLadders=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            Ladder ladder=new Ladder(5,i);
            ladders.add(ladder);
            DirectionOfLadder directionOfLadder1=new DirectionOfLadder(ladder,"L->R");
            DirectionOfLadder directionOfLadder2=new DirectionOfLadder(ladder,"R->L");
            directionOfLadder1.fightabout=directionOfLadder2;
            directionOfLadder2.fightabout=directionOfLadder1;
            directionOfLadders.add(directionOfLadder1);
            directionOfLadders.add(directionOfLadder2);
        }
    }

    @org.junit.Test
    public void makeMonkeys() {
        MonkeyStrategy1 strategy1=new MonkeyStrategy1(directionOfLadders);
        List<MonkeyThread> threads=new ArrayList<>();
        for (Monkey monkey:monkeys
             ) {
            DirectionOfLadder ladderdir=strategy1.chooseLadder(monkey);
            MonkeyThread thread=new MonkeyThread(monkey,ladderdir,ladderdir.getLadder().number);
            threads.add(thread);
        }
        for (Thread thread:threads
             ) {
            thread.start();
        }
    }
}