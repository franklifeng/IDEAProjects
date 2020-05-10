package com.test201908.javaextends;

/**
 * @author frank
 * @create 2020-03-26 10:07
 */
public class Student extends Person {
    @Override
    public String eat() {
        System.out.println("student:吃饭");
        return null;
    }
}
