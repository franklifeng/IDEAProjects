package com.volatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author frank
 * @create 2019-07-30 15:51
 * @deprecated  java锁之可重入锁和递归锁代码验证
 */
class Phone implements Runnable
{
    public synchronized void  sendSMS() throws Exception
    {
        System.out.println(Thread.currentThread().getName()+"\t sendSMS --");
        sendEmail();
    }
    public synchronized void  sendEmail() throws Exception
    {
        System.out.println(Thread.currentThread().getName()+"\t sendEmail --");

    }


    Lock lock = new ReentrantLock();
    @Override
    public void run()
    {
        get();
    }

    public void get()
    {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t get lock ");
            set();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void set()
    {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t set lock ");
        } finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock(true);



    public static void main(String[] args) throws Exception{
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"SS").start();

        try{TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e){e.printStackTrace(); }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone,"t3");
        Thread t4 = new Thread(phone,"t4");
        t3.start();
        t4.start();
    }
}
