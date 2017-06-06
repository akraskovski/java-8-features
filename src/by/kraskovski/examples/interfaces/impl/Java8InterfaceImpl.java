package by.kraskovski.examples.interfaces.impl;

import by.kraskovski.examples.interfaces.Java8Interface;

public class Java8InterfaceImpl implements Java8Interface{

    @Override
    public void info() {
        System.out.println("Override default method from interface");
    }

}
