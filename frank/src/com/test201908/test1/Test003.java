package com.test201908.test1;

import java.io.IOException;
import java.util.Properties;

/**
 * @author frank
 * @create 2019-09-08 9:50
 */
public class Test003 {
    public static void main(String[] args) throws IOException {
/*        Properties props = new Properties();
        props.load(Test003.class.getClassLoader().getResourceAsStream("com/test201908/frank.properties"));
        String name = props.getProperty("myName");
        System.out.println(name);*/
 /*       double d = Math.random();
        System.out.println(d);
        System.out.println((int)(d*10));*/
        StringBuffer str = new StringBuffer();
        str.insert(0,123);
        str.insert(0,5);
        str.insert(4,6);
        str.insert(5,9);
        System.out.println(str);

    }
}
