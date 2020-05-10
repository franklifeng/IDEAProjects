package com.volatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author frank
 * @create 2019-07-25 20:17
 */
public class volatile01 {

    public static void main(String[] args) {
        int a=0,b=1,c=1;
        System.out.println(a+b);

        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5,678);

        try{
          TimeUnit.SECONDS.sleep(4);
        }catch(InterruptedException e){
        	e.printStackTrace();
        }
        try{TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e){e.printStackTrace(); }

    }
}
