package com.huaweimianshi;

/**
 * @author frank
 * @create 2020-01-07 11:55
 * 报数游戏
 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出，问最后留下的那位是原来第几号。
 *
 */
public class NumberOff {

    public static boolean[] startNumberOff(int num){
        boolean[] persons = new boolean[num];
        for (int i = 0; i < persons.length; i++) {
            persons[i]=true;
        }

        int key=0;
        while (num!=1){
            for (int i = 0; i < persons.length; i++) {
                if (!persons[i])continue;
                key++;
                if (key%3==0){
                    persons[i]=false;
                }
            }
            num=0;
            for (int i = 0; i < persons.length; i++) {
                if (persons[i])num++;
            }
        }

        return persons;
    }

    public static void main(String[] args) {
        boolean[] persons = startNumberOff(6);
        for (int i = 0; i < persons.length; i++) {
            if (persons[i])System.out.println("最后留下的是原来的："+(i+1)+" 号" );
        }
    }
}
