package com.test201908.test1;

/**
 * @author frank
 * @create 2019-08-15 9:14
 */
public class Test001 {
    public  static int a = 1;
    public static int loop(int n){
        if(n==1||n==2)
        {
            return n;
        }
        int one = 1;
        int two = 2;
        int sum = 0;
        for (int i = 3; i <=n ; i++)
        {
            sum = one +two;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = loop(40);
        System.out.println(n);

        System.out.println(f(40));
    }

    public static int f(int n)
    {
        if(n==1||n==2)
        {
            return n;
        }
        return f(n-1)+f(n-2);
    }
}
