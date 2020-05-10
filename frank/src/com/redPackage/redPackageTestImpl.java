package com.redPackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author frank
 * @create 2019-08-22 8:50
 */
public class redPackageTestImpl implements redPackageTest{
    public static int count=1;

    public redPackageTestImpl(){}
    public redPackageTestImpl(int count)
    {
        this.count = count;
    }

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                                                            1,
                                                            count,
                                                            3,
                                                            TimeUnit.SECONDS,
                                                            new LinkedBlockingQueue(5)
                                                                  );

    @Override
    public void robRedPackage() {
        new redPackageTestImpl(count);
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i <count ; i++) {
            threadPoolExecutor.execute(new robRedPackage(countDownLatch,i));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("手慢了，红包抢光了");


//        threadPoolExecutor.shutdown();
    }

    @Override
    public void shutDownThreadPool(){
        threadPoolExecutor.shutdown();
    }
}
class robRedPackage implements Runnable{
    CountDownLatch countDownLatch;
    int count;
    public robRedPackage(CountDownLatch countDownLatch,int count){
        this.countDownLatch = countDownLatch;
        this.count = count;
    }


    @Override
    public void run() {
        try{TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e){e.printStackTrace(); }
        System.out.println("抢到"+count+"元红包");
        countDownLatch.countDown();
    }
}