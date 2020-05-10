package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author frank
 * @create 2020-02-02 21:16
 * @implSpec 请用代码实现同时开启一个线程打印1～52，开启另一个线程打印A～Z，最终交替打印1A2B3C...这样的数据
 *
 * 这里A~Z的字母对应的阿拉伯数字为65～90
 * 这里A~Z的字母对应的 'A'+1  --  'A'+25
 */
public class Print1_52_A_Z {
    private Lock lock = new ReentrantLock();
    private Condition condition1= lock.newCondition();
    private Condition condition2= lock.newCondition();
    private int num = 1;//等于1 打印数字，等于2打印字母

    public void print1_52(){
        lock.lock();
        try
        {
            while(num!=1){
                condition1.await();
            }
            for (int i = 1; i <53 ; i++) {
                System.out.print(i);
                num = 2;
                condition2.signal();
                condition1.await();
            }

        }catch(Exception e){
        	e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void printA_Z(){
        lock.lock();
        try
        {
            while(num!=2){
                condition2.await();
            }
            for (int i = 0; i <26 ; i++) {
                System.out.print((char)('A'+i));
                num = 1;
                condition1.signal();
                condition2.await();
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        System.out.println((char)('A'+25));
        System.out.println((char)90);
        Print1_52_A_Z print1_52_a_z = new Print1_52_A_Z();

        new Thread(()->{
            print1_52_a_z.print1_52();
        },"AA").start();

        new Thread(()->{
            print1_52_a_z.printA_Z();
        },"BB").start();
    }
}
