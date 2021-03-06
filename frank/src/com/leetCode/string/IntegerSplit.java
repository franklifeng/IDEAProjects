package com.leetCode.string;

/**
 * @author frank
 * @create 2020-02-24 16:48
 * @implSpec  给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。

解题思路：
首先，任何一个数字 nn，都可以被分为有限个小数字之和 n = n1 + n2 + ... + nM。


根据常理： 一般这 M 个数字的乘积要大于原数字 n。
其次，所有数字n 都可以通过对一个因子 x 求整数部分 a（a = n // x） 和余数部分 b （ b = n % x）；

即得出数字 n 由 a 个 x 和 1 个 b 相加而成。
问题转化： 是否有优先级最高的因子 x 存在？若有，我们就可以把问题转化为求 x^a * b 这个表达式的最大值。

例如：2 = 1 + 1，1 * 1 < 2，因此 2 比 1+1 更优；

例如：3 = 1 + 2，1 * 2 < 3，因此 3 比 1 和 2 更优；

例如：4 = 2 + 2，2 * 2 = 42?2=4，因此可以认为 4 与 2 等价，因此见到 4 就拆分；

例如：5 = 2 + 3；因为每个 55 都可以拆分为 2+32+3，而 2 * 3 = 6 > 5，因此见到 5 就拆分。

例如：6 = 3 + 3 = 2 + 2 + 2；因为 3 * 3 > 2 * 2 * 2 > 6。因此见到 6 就拆分，并且 3 是比 2 更优的因子。

易推出： 大数字都可以被拆分为多个小因子，以获取更大的乘积，只有 2 和 3 不需要拆分。

n	拆分	乘积
2	1+1	1	不拆分，2 比 1+1 更优
3	1+2	2	不拆分，3 比 1+2 更优
4	2+2	4	拆分，2 与 4 等价
5	2+3	6	拆分
6	3+3	9	拆分，3+3 比 2+2+2 更优
7	2+2+3	12	拆分，但不能拆成 1+3+3
观察以上枚举，我们可以列出以下贪心法则：

第一优先级： 3；把数字 nn 拆成尽可能多的 3 之和；
特殊情况： 拆完后，如果余数是 11；则应把最后的 3 + 1 替换为 2 + 2，因为后者乘积更大；
第二优先级： 2；留下的余数如果是 2，则保留，不再拆为1+1。
算法流程：

当 n <= 3 时，按照贪心规则应直接保留原数字，但由于题目要求必须拆分，因此必须拆出一个 1，即直接返回 n - 1；
求 n 除以 3 的整数部分 a 和余数部分 b；
当 b == 0 时，直接返回 3^a；
当 b == 1 时，要将一个 1 + 3 转换为 2+2，此时返回 3^{a-1} * 4；
当 b == 2 时，返回 3^a * b 。
复杂度分析：
时间复杂度 O(1) ： 仅有求整、求余、次方运算。
求整和求余运算：查阅资料，提到不超过机器数的整数可以看作是 O(1) ；
次方运算：查阅资料，提到不超过机器数的整数可以看作是 O(1) 。
空间复杂度 O(1) ： a 和 b 使用常数大小额外空间。

 */
public class IntegerSplit {

    public static void main(String[] args) {
        int n =10;
        System.out.println(integerSplit(n));
    }

    public static int integerSplit(int n){
        if(n<=3) return n-1;
        int a = n/3;
        int b = n%3;
        if (b==0) return (int)(Math.pow(3,a));
        if (b==1) return (int)(Math.pow(3,a-1)*4);
        return (int)(Math.pow(3,a))*b;


    }


}
