package com.designPatterns.factoryPatterns.simpleFactory;

/**
 * @author frank
 * @create 2019-09-08 18:27
 */
public class Test {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new CarFactory();
        Moveable m = vehicleFactory.create();
        m.run();
    }
}
