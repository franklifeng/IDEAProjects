package com.algorithm;


/**
 * @author frank
 * @create 2020-02-24 10:04
 * @implSpec 问题描述：将整数N分成K个整数的和且每个数大于等于A小于等于B，求有多少种分法
 *
 * 感觉有问题，还需要好好思索
 */
public class NumberDivide {

    public static void main(String[] args) {
        int a = dynamics(10,3,4);
        System.out.println(a);
    }

    //一般这种问题都使用分治算法，递归
    public static int dynamics(int n, int k, int min){
        if(n<min)return 0;
        if (k==1)return 1;
        int sum = 0;
        int B =9;

        for(int t = min; t <= B; t++)
        {
            sum += dynamics(n-t, k-1, t);
        }
        return sum;

    }
}
