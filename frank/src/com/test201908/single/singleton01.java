package com.test201908.single;

import com.sun.corba.se.spi.logging.LogWrapperFactory;
import sun.rmi.runtime.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author frank
 * @create 2019-08-15 14:20
 */
public class singleton01 implements Callable{
    private static final singleton01 INSTANCE =null;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new singleton01());
        Thread t01 = new Thread(futureTask,"aa");
        t01.start();
        futureTask.get();
        System.out.println(futureTask.get());

        System.out.println("=============");

    }


    @Override
    public Object call() throws Exception {
        String a = "";
        while (a.equals("11")){
            throw new Exception("123456");
        }
        try{
            TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e){e.printStackTrace(); }
        return 190;
    }
}
