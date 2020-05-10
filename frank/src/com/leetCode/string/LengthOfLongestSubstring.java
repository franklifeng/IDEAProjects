package com.leetCode.string;

/**
 * @author frank
 * @create 2019-12-18 9:29
 * @deprecated 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *    解题思路
 *    以  String s = "abcabcbb" 字符串为例子来解说
 *        a b c a b c b b
 *        1 2 3 4 5 6 7 8  j      循环次数
 *        1 2 3 4 5 6 7 8  index  下标位置
 *        就是开始的时候  index[a]=0 初始化值都是 0 ，当第一次循环得到 index[a] 赋值为 1；对应 a 字母的下标，
 *        1.当 a 有重复字母出现时  i 的值变为了 1，就是前面字母 a 对应的下标，j 的值对应的就是现在这个重复字母对应的下标，
 *          这个时候就可以计算 ans 最长子串 的长度，然后把下标移动到当前位置 index[a] = j;
 *        2.同理 当 b 有重复字母出现时 i 的值就是 2 index[b]=1;
 *
 *        循环完成后就可以得到一个字符串其中不含有重复字符的 最长子串 的长度
 *        我是为了方便理解没有把循环 j 从零开始
 *
 *
 */
public class LengthOfLongestSubstring {
    public static int  lengthOfLongestSubstring(){
        String s = "abcabcbb";
        int n=s.length(),ans=0;
        int[] index = new int[128];
        for (int i = 0,j=1; j <n ; j++) {
            i = Math.max(index[s.charAt(j)],i);
            ans = Math.max(ans,j-i);
            index[s.charAt(j)]=j;
        }

        return ans;
    }

    public static void main(String[] args) {
/*        String s = "abcabcbb";
        int[] index = new int[128];
        System.out.println(s.charAt(1));
        for (int i = 0; i < s.length(); i++) {
            System.out.println(index[s.charAt(i)]+"  ,"+i);
        }
        System.out.println(index[s.charAt(1)]);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(index[s.charAt(i)]+","+i);
        }
        System.out.println(s.substring(0,s.length()-1));*/
        int a= lengthOfLongestSubstring();
        System.out.println(a);
    }
}
