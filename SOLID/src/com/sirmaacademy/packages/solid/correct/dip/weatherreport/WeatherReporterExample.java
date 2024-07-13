package com.sirmaacademy.packages.solid.correct.dip.weatherreport;

public class WeatherReporterExample {
    public static void main(String[] args) {
        WeatherReporter wr = new WeatherReporter(new BoschSensor());
        System.out.println(wr.report());
    }
}
