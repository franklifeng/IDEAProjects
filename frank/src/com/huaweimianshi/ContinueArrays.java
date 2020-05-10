package com.huaweimianshi;

/**
 * @author frank
 * @create 2020-01-05 10:17
 * @deprecated 如何判断一组数字是否连续
 */
public class ContinueArrays {
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,6};
        boolean flag = true;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i]+1!=a[i+1])flag = false;
        }
        System.out.println(flag);
    }
}
