package com.huaweimianshi;


import sun.security.krb5.internal.Ticket;

/**
 * @author frank
 * @create 2020-01-06 13:13
 * @implSpec 抢票系统
 * <p>
 * 多线程编程
 */
public class TicketGrabbing {

    private int num =0;    //
    private int count =10;//总共的票数


    public void grabbing() {

        while (true) {
            synchronized (this)
            {
                if (count < 1) break;
                //开始抢票
                num++;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("显示出票信息:" + Thread.currentThread().getName() + "\t "
                        + "抢到第 " + num + " 张票" + " ,剩余票数：" + count);
            }
        }
    }



    public static void main(String[] args) {
        TicketGrabbing ticketGrabbing = new TicketGrabbing();
        new Thread(() -> {
            ticketGrabbing.grabbing();
        }, "AA").start();

        new Thread(()->{
            ticketGrabbing.grabbing();
        },"BB").start();

    }
}
