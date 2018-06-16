package com.company;

import java.util.ArrayList;

public class MonkeyStatus implements Status {
    private Status waitStatus=new WaitStatus(0);
    private Status moveStatus=new MoveStatus();
    private Status arrivedStatus=new ArrivedStatus();
    private Status temStatus=waitStatus;
    /**
     * 进行状态转移，从岸上爬到了梯子上
     * @param numOfLadder 选择的几号梯子
     * @return 是否成功
     */
    public boolean ComeToLadder(int numOfLadder){
        if (this.temStatus!=waitStatus){
            return false;
        }
        int birthTime=((WaitStatus)waitStatus).getBirthTime();
        this.temStatus=moveStatus;
        temStatus=(MoveStatus)temStatus;
        ((MoveStatus) temStatus).setPedal(0);
        ((MoveStatus) temStatus).setNumLadder(numOfLadder);
        ((MoveStatus) temStatus).setBirthTime(birthTime);
        return true;
    }

    /**
     * 到达对岸
     * @return 是否成功
     */
    public boolean ArrivedOtherShore(){
        if (this.temStatus!=moveStatus){
            return false;
        }
        int birthtime=((MoveStatus)moveStatus).getBirthTime();
        this.temStatus=arrivedStatus;
        arrivedStatus=(ArrivedStatus)arrivedStatus;
        ((ArrivedStatus) arrivedStatus).setTotalTime(birthtime);
        return true;
    }

    public Status getTemStatus() {
        return temStatus;
    }
}
