package com.company;

import java.security.acl.LastOwnerException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MonkeyStrategy3 implements Strategy {
    private List<DirectionOfLadder> directionOfLadders;
    public MonkeyStrategy3(List<DirectionOfLadder> directionOfLadders) {
        this.directionOfLadders=directionOfLadders;
    }

    @Override
    public DirectionOfLadder chooseLadder(Monkey monkey) {
        Queue<DirectionOfLadder> queue=new PriorityQueue<>((o1, o2) -> o2.getLadder().minDis-o1.getLadder().minDis);
        String direction=monkey.getDirection();
        if (direction.equals("L->R")){
            for (DirectionOfLadder ladderdir:directionOfLadders
                 ) {
                if (ladderdir.isDirection()){
                    queue.offer(ladderdir);
                }
            }
        }else {
            for (DirectionOfLadder ladderdir:directionOfLadders
                    ) {
                if (!ladderdir.isDirection()){
                    queue.offer(ladderdir);
                }
            }
        }
        DirectionOfLadder directionOfLadder= queue.peek();
        return directionOfLadder;
    }
}
