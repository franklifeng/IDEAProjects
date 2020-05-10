package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author frank
 * @create 2020-02-05 8:23
 */
public class BlockingQueueProConsumer {
    private volatile boolean FLAG = true;
    private BlockingQueue blockingQueue = null;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public BlockingQueueProConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void product() throws Exception {

        boolean result = false;
        String data = "";
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "\t " + data + ",生产成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t " + data + ",生产失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t " + data + ",大老板叫停了,表示生产动作结束");


    }

    public void consumer() throws Exception {

        Object result = "";
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null && "".equals(result)) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t " + result + ",超过2秒没有取的蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t " + result + ",消费成功");

        }

    }

    public void stop() throws Exception {
        this.FLAG = false;
    }

    public static void main(String[] args) throws Exception {
        BlockingQueueProConsumer bpc = new BlockingQueueProConsumer(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t " + "生产线程启动");
            try {
                bpc.product();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t " + "消费线程启动");
            System.out.println();
            System.out.println();
            try {
                bpc.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();


        System.out.println();
        System.out.println();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5秒钟时间到了");
        bpc.stop();


    }
}
