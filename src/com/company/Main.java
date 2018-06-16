package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    protected static int arrivedNumber=0;//记录全局中已经到达对岸的猴子个数
    public static void main(String[] args)  {
	// write your code here
        Scanner in =new Scanner(System.in);
        System.out.println("输入梯子个数：");
        int n=in.nextInt();
        System.out.println("输入梯子长度：");
        int h=in.nextInt();
        System.out.println("输入间隔时间：");
        int t=in.nextInt();
        //每次产生猴子的个数为k，1-3
        System.out.println("每次产生的猴子个数：");
        int k=in.nextInt();
        System.out.println("选择的策略为：");
        int a=in.nextInt();
        List<Ladder> ladders=new ArrayList<>();
        List<DirectionOfLadder> directionOfLadders=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            Ladder ladder=new Ladder(h,i);
            DirectionOfLadder direction1=new DirectionOfLadder(ladder,"L->R");
            DirectionOfLadder direction2=new DirectionOfLadder(ladder,"R->L");
            ladders.add(ladder);
            directionOfLadders.add(direction1);
            direction1.fightabout=direction2;
            direction2.fightabout=direction1;
            directionOfLadders.add(direction2);
        }
        //选择一种策略
        Strategy strategy=null;
        if (a==1){
            strategy=new MonkeyStrategy1(directionOfLadders);
        }else if (a==2){
            strategy=new MonkeyStrategy2(directionOfLadders);
        }else {
            strategy=new MonkeyStrategy3(directionOfLadders);
        }
        MonkeyGenerator generator=new MonkeyGenerator(k,5);
        List<Monkey> totalMonkeys=new ArrayList<>();
        int totalNumberOfMonkeys=0;
        double totalTime=0;
        while (true) {
            List<Monkey> monkeys = generator.makeMonkeys();
            totalNumberOfMonkeys += monkeys.size();
            totalMonkeys.addAll(monkeys);
            List<MonkeyThread> threads=new ArrayList<>();
            for (Monkey monkey : monkeys
                    ) {
                DirectionOfLadder ladderdir = strategy.chooseLadder(monkey);
                MonkeyThread thread = new MonkeyThread(monkey, ladderdir, ladderdir.getLadder().number);
                threads.add(thread);
            }
            threads.forEach(Thread::start);
            try {
                Thread.sleep(t * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalTime += 1;
            if (totalTime == 20) {
                break;
            }
        }
        System.out.println("程序运行中：。。。");
        while (arrivedNumber!=totalNumberOfMonkeys){ ; }
        double throughtputrate=totalNumberOfMonkeys/totalTime;
        int c=(totalNumberOfMonkeys*(totalNumberOfMonkeys-1))/2;
        double f=0;
        for (int i = 0; i <totalNumberOfMonkeys-1 ; i++) {
            for (int j = i+1; j <totalNumberOfMonkeys ; j++) {
                Monkey monkey1=totalMonkeys.get(i);
                Monkey monkey2=totalMonkeys.get(j);
                f+=(monkey1.getAbsolutetime1()-monkey2.getAbsolutetime1())*(monkey1.getAbsolutetime2()-monkey2.getAbsolutetime2())>0?1:0;
            }
        }
        double fairness=f/c;
        System.out.printf("吞吐率为：%.2f",throughtputrate);
        System.out.println("公平性为："+fairness);
    }
}
