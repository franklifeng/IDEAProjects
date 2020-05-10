package com.volatileTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author frank
 * @create 2019-07-31 21:27
 * @apiNote 信号灯 信号量  小米秒杀
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<=10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 开始抢车位");
                    try{TimeUnit.SECONDS.sleep(3); }catch(InterruptedException e){e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }


}
