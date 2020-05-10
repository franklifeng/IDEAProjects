package com.redPackage;

/**
 * @author frank
 * @create 2019-08-22 9:17
 */
public class Test001 {
    public static void main(String[] args) {
        /*
            如何抢红包
            首先加载构造进行初始化
            调用抢红包方法
         */
        redPackageTest redPackageTest = new redPackageTestImpl(5);

        redPackageTest.robRedPackage();
        redPackageTest.shutDownThreadPool();
    }
}
