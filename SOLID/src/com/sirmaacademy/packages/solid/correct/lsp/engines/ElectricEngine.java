package com.sirmaacademy.packages.solid.correct.lsp.engines;

public class ElectricEngine extends Engine{

    private ElectricEngineNoiseGenerator electricEngineNoiseGenerator = new ElectricEngineNoiseGenerator();

    public ElectricEngine(int horsepower) {
        super(horsepower, FuelType.ELECTRICITY);
    }

    @Override
    public void boot() {
        System.out.println(electricEngineNoiseGenerator.generateNoise(super.getHorsepower()));
    }
}
