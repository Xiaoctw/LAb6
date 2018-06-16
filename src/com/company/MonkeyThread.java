package com.company;

/**
 * 猴子开始过河的时候，启动这个线程，很好理解，因为过河开始时占用梯子
 */
public class MonkeyThread extends Thread {

    private Monkey monkey;//对应的猴子
    private DirectionOfLadder directionOfLadder;
    private int numOfLadder;
    private Ladder ladder;
    public MonkeyThread(Monkey monkey,DirectionOfLadder directionOfLadder,int numOfLadder) {
        this.directionOfLadder=directionOfLadder;
        this.monkey=monkey;
        this.numOfLadder=numOfLadder;
        ladder=directionOfLadder.getLadder();
        ladder.addMonkey(monkey);
    }

    @Override
    public void run() {
        synchronized (directionOfLadder.fightabout) {//锁住对应的梯子及其相反方向
            String dir=null;
            if (directionOfLadder.fightabout.isDirection()){
                dir="L->R";
            }else {
                dir="R->L";
            }
            System.out.println("猴子"+monkey.getID()+"锁住了"+"梯子"+ladder.number+"的"+dir+"方向");
            super.run();
            directionOfLadder.getLadder().numMonkey++;
            directionOfLadder.isFree=false;//表示这个方向有猴子了
            monkey.status.ComeToLadder(numOfLadder);
            int v = monkey.getV()<ladder.maxSpeed?monkey.getV():ladder.maxSpeed;//获取这个猴子的速度
            int dis=0;//猴子行走的路程
            while (dis<=directionOfLadder.getLadder().getH()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Status status = monkey.status.getTemStatus();//这里应该获得的是猴子的temstatus
                status=(MoveStatus)status;
                int birthtime=((MoveStatus) status).getBirthTime();
                int numPadal=((MoveStatus)status).getPedal();
                ((MoveStatus) status).setPedal(numPadal+v);
                ((MoveStatus) status).setBirthTime(birthtime+1);
                dis+=v;
            }
            monkey.status.ArrivedOtherShore();//到达对岸
            Main.arrivedNumber++;
            monkey.setAbsolutetime2(System.currentTimeMillis());
            directionOfLadder.isFree=true;
            ladder.monkeys.remove(monkey);
            ladder.numMonkey--;
            if (ladder.numMonkey==0){
                ladder.latestMonkey=null;
            }
        }
        String dir=null;
        if (directionOfLadder.fightabout.isDirection()){
            dir="L->R";
        }else {
            dir="R->L";
        }
        System.out.println("猴子"+monkey.getID()+"释放了"+"梯子"+ladder.number+"的"+dir+"方向");
    }
}
