package com.sirmaacademy.packages.solid.correct.dip.lightswitch;

public class Bulb implements Switchable {

    public Bulb() {
    }

    @Override
    public void turnOn() {
        System.out.println("⚪");
    }

    @Override
    public void turnOff() {
        System.out.println("⚫");
    }
}
