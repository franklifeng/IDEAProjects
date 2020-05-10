package com.huaweimianshi;

import java.util.Scanner;

/**
 * @author frank
 * @create 2020-01-06 9:01
 * @see
 * ：假设有九宫格输入法键盘布局如下
[ 1,.?! ] [ 2ABC ] [ 3DEF  ]
[ 4GHI  ] [ 5JKL ] [ 6MNO  ]
[ 7PQRS ] [ 8TUV ] [ 9WXYZ ]
[ 0空  ]
注意：中括号[ ]仅为了表示键盘的分隔，不是输入字符。每个中括号中，位于首位的数字字符即是键盘的按键，按一下即可输入该数字字符。多次按同一个键，则输入的字符依次循环轮流，例如按两次3，则输入D；按5次7，则输入S；按6次2，则输入A。按键0的输入组合是0和空格字符，即按两次0输入空格。
你需要对于给定的按键组合，给出该组合对应的文本。
输入格式:
输入在一行中给出数个字符的按键组合（例如?999?表示按3次9），每个字符的按键组合之间用空格间隔，最后一个输入法组合之后以换行结束。输入数据至少包括一个字符的按键组合，且输入总长度不超过500个字符。
输出格式:
在一行中输出该按键组合对应的文本。
输入样例:
22 5555 22 666 00 88 888 7777 4444 666 44
输出样例:
ALAN TURING
 */
public class Sudoku {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("------"+str);
        String[] strArrays = str.split(" ");
        System.out.println(strArrays.length);

        for (int i = 0; i < strArrays.length; i++) {
            int len = strArrays[i].length();
            char c = strArrays[i].charAt(0);
            switch (c){
                case '0':
                    if (len%2==1)System.out.print("0");
                    if (len%2==0)System.out.print("");
                    break;
                case '1':
                    if (len%5==1)System.out.print("1");
                    if (len%5==2)System.out.print(",");
                    if (len%5==3)System.out.print(".");
                    if (len%5==4)System.out.print("?");
                    if (len%5==0)System.out.print("!");
                    break;
                case '2':
                    if (len%4==1)System.out.print("2");
                    if (len%4==2)System.out.print("A");
                    if (len%4==3)System.out.print("B");
                    if (len%4==0)System.out.print("C");
                    break;
                case '3':
                    if (len%4==1)System.out.print("3");
                    if (len%4==2)System.out.print("D");
                    if (len%4==3)System.out.print("E");
                    if (len%4==0)System.out.print("F");
                    break;
                case '4':
                    if (len%4==1)System.out.print("4");
                    if (len%4==2)System.out.print("G");
                    if (len%4==3)System.out.print("H");
                    if (len%4==0)System.out.print("I");
                    break;
                case '5':
                    if (len%4==1)System.out.print("5");
                    if (len%4==2)System.out.print("J");
                    if (len%4==3)System.out.print("K");
                    if (len%4==0)System.out.print("L");
                    break;
                case '6':
                    if (len%4==1)System.out.print("6");
                    if (len%4==2)System.out.print("M");
                    if (len%4==3)System.out.print("N");
                    if (len%4==0)System.out.print("O");
                    break;
                case '7':
                    if (len%5==1)System.out.print("7");
                    if (len%5==2)System.out.print("P");
                    if (len%5==3)System.out.print("Q");
                    if (len%5==4)System.out.print("R");
                    if (len%5==0)System.out.print("S");
                    break;
                case '8':
                    if (len%4==1)System.out.print("8");
                    if (len%4==2)System.out.print("T");
                    if (len%4==3)System.out.print("U");
                    if (len%4==0)System.out.print("V");
                    break;
                case '9':
                    if (len%5==1)System.out.print("9");
                    if (len%5==2)System.out.print("W");
                    if (len%5==3)System.out.print("X");
                    if (len%5==0)System.out.print("Y");
                    if (len%5==0)System.out.print("Z");
                    break;
                default :
                    break;
            }
        }

    }
}
