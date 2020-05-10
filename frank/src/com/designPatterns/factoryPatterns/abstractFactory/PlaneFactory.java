package com.designPatterns.factoryPatterns.abstractFactory;

/**
 * @author frank
 * @create 2019-09-08 18:53
 */
public class PlaneFactory implements AbstractFactory {
    @Override
    public Moveable create() {
        return new Plane();
    }
}
