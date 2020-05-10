package com.algorithm;

/**
 * @author frank
 * @create 2020-02-21 10:55
 * 汉诺塔游戏属于 分治算法
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoitower(3,'A','B','C');
    }

    //汉诺塔游戏，a,b,c 三个柱子，num个盘子，盘子都在 a 柱子，把盘子从 a 移动到 c
    public static void hanoitower(int num, char a, char b, char c){
        if (num == 1){
            System.out.println("第1个盘从 " + a + "->" + c);
        }else{
            //分2种，上面所有的为一个，下面最后一个为一个
            //先把上面的移动到 b 柱子，再把最下面的一个移动到 c
            //从 a 移动到 b ，借助 c
            hanoitower(num-1,a,c,b);
            //把最下面的一个移动到 c
            System.out.println("第" + num + "个盘从 " + a + "->" +c);
            //从 b 移动到 c ，借助 a
            hanoitower(num-1,b,a,c);
        }
    }

}
