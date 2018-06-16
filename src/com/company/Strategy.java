package com.company;

/**
 * 这个策略只是用来选梯子，在还没有锁住的对应的不同梯子的方向选择合适的
 * 如果返回null，说明此事没有可以爬上的的梯子，返回null
 */
public interface Strategy {
    public DirectionOfLadder chooseLadder(Monkey monkey);
}
