package com.volatileTest;

/**
 * @author frank
 * @create 2019-07-25 21:11
 */
public class SingletonDemo {
    //volatile可以禁止指令重排
    private static  volatile SingletonDemo instance =null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 线程是否唯一");
    }

    //DCL double  check lock 双端检锁机制
    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized(SingletonDemo.class){
                if (instance == null)
                {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
 /*       for(int i=1;i<=10;i++){
           new Thread(()->{
                SingletonDemo.getInstance();
           }, String.valueOf(i)).start();
        }*/

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
