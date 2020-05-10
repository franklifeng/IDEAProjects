package com.test201908.single;

import sun.rmi.runtime.Log;

import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * @author frank
 * @create 2019-08-15 15:14
 */
public class singleton02 implements Runnable{
    private static Logger logger = Logger.getLogger(singleton02.class.getName());

    @Override
    public void run() {
        String a = "";
        while (a.equals("11")){
            try {
                throw new Exception("123456");
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        try{TimeUnit.SECONDS.sleep(3); }catch(InterruptedException e){e.printStackTrace(); }
        System.out.println("11111");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new singleton02(),"AA");
        t.start();
        System.out.println("==========");
/*        System.out.println(singleton02.class.getName());

        logger.info("123456");

        Callable<singleton02> callable = new Callable<singleton02>() {
            @Override
            public singleton02 call() throws Exception {
                return null;
            }
        };
        ExecutorService e = Executors.newFixedThreadPool(2);
        Future<singleton02> futureTask = e.submit(callable);*/
    }
}
