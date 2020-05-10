package com.test201908.test1;

import com.test201908.single.TestSingletonEnum;

import java.util.HashMap;

/**
 * @author frank
 * @create 2019-08-15 9:15
 */
public class Test001Sub01 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        new Thread(()->{}).start();
        TestSingletonEnum t1 = TestSingletonEnum.INSTANCE;
        System.out.println(t1.hashCode());
        TestSingletonEnum t2 = TestSingletonEnum.INSTANCE;
        System.out.println(t2.hashCode());
        System.out.println(t1==t2);
        new HashMap<>();
    }
}
