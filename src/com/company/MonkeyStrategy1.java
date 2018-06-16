package com.company;

import java.util.List;

/**
 * 这个策略比较简单，直接返回第一个发现的空闲的梯子
 */
public class MonkeyStrategy1 implements Strategy {
    //保存所有的梯子
    private List<DirectionOfLadder> directionOfLadders;
    public MonkeyStrategy1(List<DirectionOfLadder> ladders) {
        this.directionOfLadders=ladders;
    }

    @Override
    public DirectionOfLadder chooseLadder(Monkey monkey) {
//        for (Ladder ladder:ladders
//             ) {
//            if (ladder.leftToRightFree&&ladder.rightToLeftFree){
//                return ladder;
//            }
//        }
//        String dir=monkey.getDirection();
//        if (dir.equals("L->R")){
//            for (Ladder la : ladders) {
//                if (la.leftToRightFree){
//                    return la;
//                }
//            }
//        }else {
//            for (Ladder ladder:ladders){
//                if (ladder.rightToLeftFree){
//                    return ladder;
//                }
//            }
//        }
//        return null;
        String dir=monkey.getDirection();
        if (dir.equals("L->R")){
            for (DirectionOfLadder ladderdir:directionOfLadders
                 ) {
                if (ladderdir.isFree&&ladderdir.isDirection()){
                    ladderdir.isFree=false;
                    return ladderdir;
                }
            }
        }else {
            for (DirectionOfLadder ladderdir:directionOfLadders
                 ) {
                if (ladderdir.isFree&&!ladderdir.isDirection()){
                    ladderdir.isFree=false;
                    return ladderdir;
                }
            }
        }
        //如果当前没有空闲的梯子，那么用策略2解决问题
        return new MonkeyStrategy2(directionOfLadders).chooseLadder(monkey);
//        String dir=monkey.getDirection();
//        if (dir.equals("L->R")){
//            for (DirectionOfLadder ladderdir:directionOfLadders
//                    ) {
//                if (ladderdir.isFree&&ladderdir.isDirection()){
//                    ladderdir.isFree=false;
//                    return ladderdir;
//                }
//            }
//        }else {
//            for (DirectionOfLadder ladderdir:directionOfLadders
//                    ) {
//                if (ladderdir.isFree&&!ladderdir.isDirection()){
//                    ladderdir.isFree=false;
//                    return ladderdir;
//                }
//            }
//        }
//        return null;
    }
}
