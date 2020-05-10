package com.leetCode.string;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;


/**
 * @author frank
 * @create 2020-03-02 9:43
 * <p>
 * 单词压缩编码  我在题目的基础上自己增加求 indexs 下标，使用了kmp 算法
 * <p>
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串S与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S?中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * 示例：
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 * 提示：
 * 1 <= words.length?<= 2000
 * 1 <=words[i].length<= 7
 * 每个单词都是小写字母
 */
public class CharacterCompressedEncoding {

    public static void main(String[] args) {
        String[] str = {"time", "me", "bell", "ll"};
        Set<String> set = new HashSet<>(Arrays.asList(str));
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(set);
        for (String word : str) {
            for (int i = 1; i < word.length(); i++) {
                if (set.remove(word.substring(i))) map.put(word, i);
            }
        }
        System.out.println(set);
        System.out.println(map);

        String good = "";
/*        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            good += it.next();
        }*/
        for (String b : set) {
            good += b + "#";
        }
        System.out.println(good);
        int [] next = null;
        int index = 0;
        List<Integer> list = new ArrayList<>();

        Map<String,Integer> indexMap = new HashMap<String,Integer>();
        for (String c : set){
            next = kmpNext(c);
            index = kmpsearch(good,c,next);
            indexMap.put(c,index);
            list.add(index);
        }
        for (String s : map.keySet()){
            if (map.get(s)!=indexMap.get(s)){
                index = map.get(s)+indexMap.get(s);
                list.add(index);
            }
        }
        System.out.println("--------list:"+list);
        Collections.sort(list);
        int [] indexs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            indexs[i] = list.get(i);
        }
        System.out.println(Arrays.toString(indexs));

    }

    public static int[] kmpNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static Integer kmpsearch(String str1, String str2, int[] next) {
        for (int i = 0,j=0; i < str1.length(); i++) {
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }
}
