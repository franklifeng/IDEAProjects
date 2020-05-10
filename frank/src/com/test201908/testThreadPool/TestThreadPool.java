package com.test201908.testThreadPool;

import java.util.concurrent.*;

import static java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * @author frank
 * @create 2019-08-21 16:26
 */
public class TestThreadPool {

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                                                                        3,
                                                                        5,
                                                                        2,
                                                                        TimeUnit.SECONDS,
                                                                        new LinkedBlockingQueue<>(5),
                                                                        Executors.defaultThreadFactory(),
                                                                        new ThreadPoolExecutor.DiscardPolicy()
                                                                );

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <6 ; i++) {
            threadPoolExecutor.execute(new ProThreadPool(i+"",countDownLatch));
        }



        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("红包抢完了");

    }


}
class ProThreadPool implements Runnable{
    final String str;
    CountDownLatch countDownLatch;
    public ProThreadPool(String str ){
        this.str=str;

    }

    public ProThreadPool(String str,CountDownLatch countDownLatch){
        this.str=str;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try{TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e){e.printStackTrace(); }
        System.out.println("我抢到红包了"+str);
        countDownLatch.countDown();
    }
}