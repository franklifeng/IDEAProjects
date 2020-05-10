package com.test201908.test1;

/**
 * @author frank
 * @create 2019-08-15 9:17
 */
public class Test001Sub02 {
    public static void main(String[] args) {
        int a = 1;
        a=a++;
        int b = a++;
        int c= a + ++a*a++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
