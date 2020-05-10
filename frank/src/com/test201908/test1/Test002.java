package com.test201908.test1;

import java.util.HashMap;

/**
 * @author frank
 * @create 2019-08-20 20:41
 */
public class Test002 {
    public static void main(String[] args) {
        System.out.println(1 << 30);
        new HashMap<>();
        System.out.println(Math.ceil(-0.8/ 0.75 ));
        System.out.println(Math.ceil(-0.3 / 0.75 + 1));
        System.out.println(Math.ceil(111111111 / 0.75 ));
        System.out.println(Math.ceil(111111111 / 0.75 + 1));
        System.out.println((int)Math.ceil(111111111 / 0.75 ));
    }
}
