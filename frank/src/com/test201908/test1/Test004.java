package com.test201908.test1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author frank
 * @create 2019-12-29 11:21
 */
public class Test004 {
    public static void main(String[] args) {
/*        int a = (int) (Math.random()*10)+1;
        System.out.println(a);

        for (int i = 0; i < 6; i++) {
            System.out.println((int)(Math.random()*30)+1);
        }*/
        String[] words = new String[]{"time", "me", "bell"};
        System.out.println(Arrays.asList(words));
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }
        System.out.println(good);


    }
}
