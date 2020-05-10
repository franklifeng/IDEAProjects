package com.designPatterns.factoryPatterns.abstractFactory;


/**
 * @author frank
 * @create 2019-09-08 18:25
 */
public class Car implements Moveable {
    @Override
    public void run() {
        System.out.println("Car 加满油，检修好开始出发了去旅游了。。。。。");
    }
}
