package com.algorithm.mianshi;

/**
 * @author frank
 * @create 2020-02-28 11:31
 * @implSpec 求1到100之间所有偶数的和。用for和while语句分别完成。
 */
public class EvenNumberSum {
    public static void main(String[] args) {
        forEvenSum();

//        whileEvenSum();
    }

    private static void forEvenSum() {
        int temp = 0;
        for (int i = 0; i < 101 ; i++) {
            if (i%2==0){
                temp += i;
            }
        }
        System.out.println(temp);
    }

    private static void whileEvenSum() {
        int a = 0;
        int temp = 0;
        while (a<=100){
            if (a%2 == 0){
                temp += a;
            }
            a++;
        }
        System.out.println(temp);
    }
}
