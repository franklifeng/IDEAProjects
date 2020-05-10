package com.test201908;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 * @author frank
 * @create 2020-01-07 22:35
 * yyyy-MM-dd'T'HH:mm:ss.SSS
 */
public class Test001 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();

            if ("01".equals(str))break;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sf.parse("1992-08-20 12:12:12.001");
        Date date1 = sf.parse("1992-08-20 12:12:12.002");
//        Collections.sort();
        System.out.println(date.equals(date1));
        System.out.println(date);
    }
}
