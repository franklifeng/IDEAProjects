package com.test201908;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author frank
 * @create 2019-12-29 10:00
 *
 * @deprecated 100以内所有质数的输出
 * 质数又称素数.指在一个大于1的自然数中,除了1和此整数自身外,没法被其他自然数整除的数.
 * 换句话说,只有两个正因数(1和自己)的自然数即为素数.比1大但不是素数的数称为合数.1和0既非素数也非合数.
 *
 */
public class PrimeNumberOutput {
    public static void main(String[] args) {
        //第一种方法
        Method01();

        //第二种方法
//        Method02();



    }

    public static void Method02() {
        boolean flag = true;
        for (int i =2 ; i<100;i++){

            for (int j = 2; j<i; j++){
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }

            if (flag){
                System.out.println(i);
            }

            flag = true;
        }
    }

    public static void Method01() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <=100 ; i++) {
            int a = 0;   //整除次数
            for (int j = 1; j <= i; j++) {
                if (i%j==0){
                    a++;
                }
            }
            if (a==2){
                list.add(i);
            }
        }

        System.out.println(list.size());
        for (Integer b:list) {
            System.out.println(b);
        }
    }
}
