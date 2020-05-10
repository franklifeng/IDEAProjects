package com.algorithm;


import java.util.*;

/**
 * @author frank
 * @create 2020-02-27 15:07
 *
 * @implSpec 贪心算法
 *
 *     假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有的地区都可以接收到信号
                广播台	覆盖地区
                K1	"北京", "上海", "天津"
                K2	"广州", "北京", "深圳"
                K3	"成都", "上海", "杭州"
                K4	"上海", "天津"
                K5	"杭州", "大连"
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        Map<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();
        HashSet<String> set1 = new HashSet<String>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<String>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<String>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<String>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<String>();
        set5.add("杭州");
        set5.add("大连");

        map.put("K1",set1);
        map.put("K2",set2);
        map.put("K3",set3);
        map.put("K4",set4);
        map.put("K5",set5);

        HashSet<String> set = new HashSet<String>();
        for (String a :set1){
            set.add(a);
        }
        for (String a :set2){
            set.add(a);
        }
        for (String a :set3){
            set.add(a);
        }
        for (String a :set4){
            set.add(a);
        }
        for (String a :set5){
            set.add(a);
        }

        System.out.println(set);
        List<String> list = new ArrayList<String>();

        //使用指针
        String maxKey = null;
        HashSet<String> tempSet = new HashSet<String>();
        while (set.size()!=0){

            for (String key : map.keySet()){
                tempSet = map.get(key);
                tempSet.retainAll(set);
                if (tempSet.size()>0 && (maxKey==null || tempSet.size()> map.get(maxKey).size())){
                    maxKey = key;
                }
            }

            list.add(maxKey);
            set.removeAll(map.get(maxKey));

        }

        System.out.println(list);

        for (String k : map.keySet()){
            System.out.println(map.get(k));
        }


    }
}
