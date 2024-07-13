package com.sirmaacademy.packages.solid.correct.dip.weatherreport;

public class WeatherReporter {
    private TemperatureSensor sensor;

    public WeatherReporter(TemperatureSensor sensor) {
        this.sensor = sensor;
    }

    public String report()
    {
        System.out.println("hhh");
        return "The temperature is " + this.sensor.getTemperature() + " degrees.";
    }

}
