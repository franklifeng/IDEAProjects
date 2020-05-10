package com.secondsKill;

import sun.applet.Main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author frank
 * @create 2019-08-22 10:18
 */
public class Test001 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(6,true);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"+秒杀到东西了,开始付钱");
                try{
                    TimeUnit.SECONDS.sleep(3); }catch(InterruptedException e){e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+":东西买到了");
                semaphore.release();
            },i+"AAA").start();
        }
    }
}
