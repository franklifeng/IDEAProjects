package com.volatileTest;

import java.util.concurrent.*;

/**
 * @author frank
 * @create 2019-08-08 8:37
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService  = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i <10 ; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t 办理业务");
            });
        }

    }
}
