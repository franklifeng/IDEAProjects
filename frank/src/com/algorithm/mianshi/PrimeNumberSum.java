package com.algorithm.mianshi;

/**
 * @author frank
 * @create 2020-02-28 12:06
 *
 * @implSpec 100以内所有质数的输出
 *
 * 质数（prime number）又称素数，有无限个。质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。

   合数指自然数中除了能被1和本身整除外，还能被其他数（0除外）整除的数。与之相对的是质数，而1既不属于质数也不属于合数。最小的合数是4。其中，完全数与相亲数是以它为基础的
 *
 */
public class PrimeNumberSum {



    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 2; i < 101; i++) {
            for (int j = 2; j < i; j++) {
                if (i%j==0)flag=false;
            }
            if (flag){
                System.out.println(i);
            }
            flag = true;
        }
//        System.out.println(num);
    }
}
