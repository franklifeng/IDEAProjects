package com.designPatterns.factoryPatterns.abstractFactory;

/**
 * @author frank
 * @create 2019-09-08 18:54
 */
public class TestAbstract {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new PlaneFactory();
        Moveable m = abstractFactory.create();
        m.run();
    }
}
