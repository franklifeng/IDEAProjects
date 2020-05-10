package com.huaweimianshi;

import java.util.Scanner;

/**
 * @author frank
 * @create 2020-01-05 10:06
 *
 * 题目描述
把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
输入
每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
样例输入
7 3
样例输出
8
 计算放苹果方法数目
 输入值非法时返回-1
 1 <= m,n <= 10
 @param m 苹果数目
 @param n 盘子数目数
 @return 放置方法总数
 *
 */
public class DivideApple {
    /**
     *
     * @param a 苹果
     * @param b 盘子
     * @return
     */
    public static int f(int a,int b){

        if (a==0||b==1){
            return 1;
        }else if (a<b){
            return f(a,a);
        }else{
            return f(a,b-1)+f(a-b,b);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = f(a,b);
        System.out.println(sum);
    }
}
