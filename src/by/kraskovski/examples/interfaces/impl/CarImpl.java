package by.kraskovski.examples.interfaces.impl;

import by.kraskovski.examples.interfaces.Car;

public class CarImpl implements Car{

    @Override
    public void info() {
        System.out.println("Override default method from interface");
    }

}
