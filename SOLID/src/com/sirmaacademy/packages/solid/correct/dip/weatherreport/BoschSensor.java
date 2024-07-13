package com.sirmaacademy.packages.solid.correct.dip.weatherreport;

public class BoschSensor implements TemperatureSensor {

    @Override
    public double getTemperature() {
        return 25;
    }
}
