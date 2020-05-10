package com.designPatterns.factoryPatterns.abstractFactory;


/**
 * @author frank
 * @create 2019-09-08 18:18
 */
public class CarFactory implements AbstractFactory{


    @Override
    public Moveable create() {
        return new Car();
    }
}
