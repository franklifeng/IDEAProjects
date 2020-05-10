package com.volatileTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author frank
 * @create 2019-07-31 22:16
 * @apiNote 集齐了才能开始，人到齐了才能开会
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{System.out.println("@@@###召唤神龙");});
        for(int i=1;i<=14;i++){
            final int tmpInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 第"+tmpInt+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                }
            }, String.valueOf(i)).start();
        }
    }

}
