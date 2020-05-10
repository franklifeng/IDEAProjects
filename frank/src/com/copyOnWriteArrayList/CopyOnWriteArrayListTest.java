package com.copyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author frank
 * @create 2019-08-22 14:11
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },i+"ABC").start();
        }
    }
}
