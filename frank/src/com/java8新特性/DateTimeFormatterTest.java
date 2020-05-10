package com.java8新特性;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author frank
 * @create 2020-01-10 9:41
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime ld = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(ld.format(df));
        String a = "1992-08-20 12:12:12.001";
        LocalDateTime ld1 = LocalDateTime.parse(a,df);
        System.out.println(ld1);
        System.out.println(ld.format(df));
    }
}
