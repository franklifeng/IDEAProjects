package com.huaweimianshi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author frank
 * @create 2020-01-08 0:03
 * 输入年月日时分秒 毫秒 ，输出多少人能抢到票
 * 1.同一秒内，若时间不同，选最早的，若存在时间相同，选择多个
 * 2.不同时间，选择时间最早的
 * 输入：
 * 1992-08-20 12:12:12.001
 * 1992-08-20 12:12:12.003
 * 1992-08-20 12:12:12.203
 * 1992-08-21 12:12:12.001
 * 1992-08-21 12:12:12.003
 * <p>
 * 输出 2
 */
public class TicketGrabbingHuaWei {
    public static void main(String[] args) throws ParseException {
        String a = "1992-08-20 12:12:12.001";
        String b = "1992-08-20 12:12:12.002";
        String c = "1992-08-20 12:12:12.203";
        String d = "1992-08-21 12:12:12.001";
        String e = "1992-08-21 12:12:12.003";
        List<String> list = new ArrayList<String>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String pattern1 = "yyyy-MM-dd HH:mm:ss.SSS";
        int num = 1;
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        SimpleDateFormat sf1 = new SimpleDateFormat(pattern1);
        Date dateA = sf.parse(a);
        Date dateB = sf.parse(b);
        Date temp = sf.parse(list.get(0));
        int size = 0;
        for (int i = 1; i < list.size(); i++) {
            if (temp.equals(sf.parse(list.get(i)))) {
                //同一秒内，比较毫秒，毫秒相等也算抢到票
                if (sf1.parse(list.get(size)).equals(sf1.parse(list.get(i)))) num++;

            } else {
                temp = sf.parse(list.get(i));
                size = i;
                num++;
                continue;
            }
        }

        System.out.println(num);
    }
}
