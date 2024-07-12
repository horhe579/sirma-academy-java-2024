package com.sirmaacademy.packages.solid.correct.lsp;

public abstract class Engine implements Bootable{

    private FuelType fuelType;
    private int horsepower;

    public Engine(int horsepower, FuelType fuelType) {
        this.horsepower = horsepower;
        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
