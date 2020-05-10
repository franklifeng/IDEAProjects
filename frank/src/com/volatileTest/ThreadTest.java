package com.volatileTest;

/**
 * @author frank
 * @create 2019-08-08 21:38
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 开始");
        }, "AAA").start();

        System.out.println(Thread.currentThread().getName()+"\t main开始");
    }

}
