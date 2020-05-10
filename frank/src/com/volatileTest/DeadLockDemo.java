package com.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * @author frank
 * @create 2019-08-07 22:39
 */
class DeadLock implements Runnable{
    private String lockA;
    private String lockB;

    DeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized(lockA)
        {
            System.out.println(Thread.currentThread().getName()+"\t 11111 lockA");
            try{
                TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e){e.printStackTrace(); }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 222222 lockB");
            }
        }
    }
}

public class DeadLockDemo {


    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadLock(lockA,lockB),"AAAA").start();
        new Thread(new DeadLock(lockB,lockA),"BBBB").start();

    }
}
