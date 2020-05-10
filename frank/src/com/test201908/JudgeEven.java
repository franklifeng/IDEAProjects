package com.test201908;

import java.util.Scanner;

/**
 * @author frank
 * @create 2019-12-29 9:39
 *
 * @deprecated 从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序
 *
 */
public class JudgeEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 0;  //正数个数
        int b = 0;  //负数个数
        while (true){
            System.out.println("请输入一个整数：");
            int temp = scanner.nextInt();
            if (temp>0){
                a++;
            }else if (temp<0){
                b++;
            }else {
                break;
            }
        }
        System.out.println("正数个数:"+a);
        System.out.println("负数个数:"+b);
    }

}
