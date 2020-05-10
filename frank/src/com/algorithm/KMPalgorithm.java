package com.algorithm;

import java.util.Arrays;

/**
 * @author frank
 * @create 2020-02-18 16:50
 * @implSpec KMP算法
 */
public class KMPalgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
//        String str2 = "ABCDABD";
        String str2 = "ABCABD";
        int [] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));

        System.out.println(kmpSearch(str1, str2, next));
    }

    //写出kmp搜索算法
    public static int kmpSearch(String str1,String str2,int []next){

        for (int i = 0,j=0; i < str1.length(); i++) {
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i-j+1;
            }

        }
        return -1;
    }

    //获取到一个字符串(子串) 的部分匹配值表
    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;//dest长度为1，则表示只有一个元素，一个元素的前缀和后缀的共有元素为0
        for (int i = 1,j=0; i < dest.length() ; i++) {
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
            }
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
