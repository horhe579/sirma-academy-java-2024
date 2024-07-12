package com.sirmaacademy.packages.solid.faulty;

public class ElectricEngine extends Engine {
    @Override
    public void start() {
        throw new UnsupportedOperationException("Electric engines do not start traditionally.");
    }
}