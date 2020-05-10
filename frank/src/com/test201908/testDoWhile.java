package com.test201908;

/**
 * @author frank
 * @create 2019-11-29 9:50
 */
public class testDoWhile {
    public static void main(String[] args) {
        int i=0,j=0;
        do{
            if (i%2 ==0){
                i++;
                continue;
            }
            i++;
            j = j + i;
        }while (i<7);

        System.out.println(j);
    }
}
