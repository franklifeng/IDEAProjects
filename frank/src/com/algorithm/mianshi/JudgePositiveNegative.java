package com.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author frank
 * @create 2020-02-28 11:51
 * @implSpec 从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。
 */
public class JudgePositiveNegative {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        List<Integer> positive = new ArrayList<Integer>();
        List<Integer> negative = new ArrayList<Integer>();
        while (sc.hasNextInt()){
            a= sc.nextInt();
            if (a==0){
                break;
            }else if (a>0){
                positive.add(a);
            }else {
                negative.add(a);
            }

        }

        System.out.println("正数是: " + positive.size() + " 个");
        System.out.println("负数是: " + negative.size() + " 个");
    }
}
