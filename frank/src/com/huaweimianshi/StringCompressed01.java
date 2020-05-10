package com.huaweimianshi;

/**
 * @author frank
 * @create 2020-02-23 11:07
 */
public class StringCompressed01 {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compress(chars);
    }

    public static int compress(char[] chars) {
        int size = 0;   //为要得到的数组下标
        int left = 0; //左下标 和 右下标
        //解题思路就是通过移动下标来进行判断
        /**
         * char[] chars = {'a','a','b','b','c','c','c'};
         * left   right
         *   0  ==  0
         *   0  ==  1
         *   0  !=  2
         *
         *   2  ==  3
         *   2  !=  4
         *
         *   4  ==  5
         *   4  ==  6
         *
         *   right - left = 2
         *
         *   char[] chars = {'a','b','b'};
         *   left   right
         *     0  ==  0
         *     0  !=  1
         *     1  ==  2
         *   right - left = 1
         *   不相等的时候 等于1则说明只有一个a （相同的字符就一个）
         *               大于1则说明有多个相同的字符
         *
         *   还需要考虑最后一个字符是相等的时候，要进入进行计算
         */
        for (int right = 0; right <= chars.length; right++) {
            if (right == chars.length || chars[left] != chars[right]) {
                chars[size++] = chars[left];
                if (right - left > 1) {
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }

        System.out.println(size);
        for (char s : chars) {
            System.out.println(s);
        }

        return size;
    }
}
