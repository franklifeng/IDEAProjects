package com.test201908;

/**
 * @author frank
 * @create 2019-12-29 9:26
 *
 * @deprecated 求1到100之间所有偶数的和。用for和while语句分别完成。
 *             偶数就是2的倍数，余数是0 ，num%2 ==0 就是偶数
 *
 */
public class cyclicEven {
    public static void main(String[] args) {
        int temp = getCyclicEven();
        System.out.println(temp);
    }

    private static int getCyclicEven() {
        int temp = 0;
        for (int i = 1; i <=100 ; i++) {
            if (i%2==0){
                temp = temp + i;
            }
        }
        return temp;
    }

}
