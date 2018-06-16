package com.company;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 这个策略优先选择梯子上猴子数量最少的梯子
 */
public class MonkeyStrategy2 implements Strategy {
    private List<DirectionOfLadder> directionOfLadders;
    public MonkeyStrategy2(List<DirectionOfLadder> directionOfLadders) {
        this.directionOfLadders=directionOfLadders;
    }

    @Override
    public DirectionOfLadder chooseLadder(Monkey monkey) {
        String dir=monkey.getDirection();
        Queue<DirectionOfLadder> queue=new PriorityQueue<>((o1, o2) -> o2.getLadder().numMonkey-o1.getLadder().numMonkey);
        if (dir.equals("L->R")){
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
        DirectionOfLadder directionOfLadder=queue.peek();
        return directionOfLadder;
//        String dir=monkey.getDirection();
//        Queue<DirectionOfLadder> queue=new PriorityQueue<>((o1, o2) -> o2.getLadder().numMonkey-o1.getLadder().numMonkey);
//        if (dir.equals("L->R")){
//            for (DirectionOfLadder ladderdir:directionOfLadders
//                    ) {
//                if (ladderdir.isFree&&ladderdir.isDirection()){
//                    queue.offer(ladderdir);
//                }
//            }
//        }else {
//            for (DirectionOfLadder ladderdir:directionOfLadders
//                    ) {
//                if (ladderdir.isFree&&!ladderdir.isDirection()){
//                    queue.offer(ladderdir);
//                }
//            }
//        }
//        DirectionOfLadder directionOfLadder=queue.peek();
//        directionOfLadder.isFree=false;
//        return directionOfLadder;
    }
}
