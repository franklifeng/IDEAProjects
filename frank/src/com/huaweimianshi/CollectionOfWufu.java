package com.huaweimianshi;

import java.util.*;

/**
 * @author frank
 * @create 2020-01-06 10:00
 * 题目：以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，随机抽取一个小于10人团队，
 * 求该团队最多可以集齐多少套五福？
输入描述:
输入若干个"11010"、”00110"的由0、1组成的长度等于5位字符串,代表的指定团队中每个人福卡获得情况
注意1：1人也可以是一个团队
注意2：1人可以有0到5张福卡，但福卡不能重复
输出描述:
输出该团队能凑齐多少套五福
示例1
输入
11001
输出
0
 *
 */
public class CollectionOfWufu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        String[] strArrays = str.split(" ");
        for (int j = 0; j < strArrays.length; j++) {
            String string = strArrays[j];
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ('1'==chars[i]){
                    if (map.get(i)!=null&&map.get(i)>0){
                        map.put(i,map.get(i)+1);
                    }else{
                        map.put(i,1);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList(map.values());
        Collections.sort(list);
        System.out.println(list.get(0));
        int a = list.get(0);
        System.out.println(a);


    }
}
