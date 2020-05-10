package com.volatileTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author frank
 * @create 2019-07-31 22:29
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws  Exception{
        CountDownLatch countDownLat = new CountDownLatch(5);
        for(int i=1;i<=6;i++){
            final int tmpInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 第"+tmpInt+"学生自习完离开教室");
                countDownLat.countDown();
            }, CountryEnum.getValue(i).getValue()).start();
        }

        countDownLat.await();

        System.out.println(Thread.currentThread().getName()+"\t 班长锁门离开教室");

    }

}
