package com.designPatterns.factoryPatterns.simpleFactory;

/**
 * @author frank
 * @create 2019-09-08 18:18
 */
public class CarFactory implements VehicleFactory{

    @Override
    public Moveable create() {
        return new Car();
    }
}
