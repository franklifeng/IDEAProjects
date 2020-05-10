package com.bigdecimalTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author frank
 * @create 2019-08-29 15:02
 */
public class Test001 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("-55.55555");
        System.out.println(a.setScale(3,RoundingMode.DOWN));
        String b = "fadsfas";
        System.out.println(b.length()<7?b.substring(1,2):b);
    }
}
