package com.algorithm.mianshi;

import com.sun.javafx.runtime.SystemProperties;

import java.util.Arrays;

/**
 * @author frank
 * @create 2020-02-24 16:14
 * @implSpec 创建一个长度为6的int型数组，要求取值为 1-30，同时元素值各不相同
 *
 * java产生随机数有两种方法：

（1）Random random = new Random();    int n = random.nextInt(最大值-最小值+1)+最小值；

（2）int n = Math.random()*(最大值-最小值+1)+最小值;
 */
public class RandomArray {

    public static void main(String[] args) {
        int[] a = new int[6];
        for (int i = 0; i < a.length; i++) {
            int b = (int)(Math.random()*(30-1+1))+1;
            a[i] = b;
            for (int j = 0; j < i&& i>0; j++) {
                if (a[j] == a[i]){
                    a[i]=0;
                    i--;
                    continue;
                }
            }
        }

        System.out.println(Arrays.toString(a));

        for (int c: a){
            System.out.println(c);
        }
    }
}
