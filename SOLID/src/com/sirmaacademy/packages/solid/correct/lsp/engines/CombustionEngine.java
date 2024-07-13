package com.sirmaacademy.packages.solid.correct.lsp.engines;

public class CombustionEngine extends Engine{

    private int cylinderCount;
    private static final int DEFAULT_CYLINDER_COUNT = 4;
    private CombustionEngineNoiseGenerator engineNoiseGenerator = new CombustionEngineNoiseGenerator();

    public CombustionEngine(int horsepower, FuelType fuelType) {
        if(fuelType == FuelType.ELECTRICITY || fuelType == FuelType.HYDROGEN)
        {
            throw new RuntimeException("ICE does not support this fuel");
        }
        super(horsepower, fuelType);
        this.cylinderCount = DEFAULT_CYLINDER_COUNT;
    }

    public CombustionEngine(int horsepower, FuelType fuelType, int cylinderCount) {
        if(fuelType == FuelType.ELECTRICITY || fuelType == FuelType.HYDROGEN)
        {
            throw new RuntimeException("ICE does not support this fuel");
        }
        super(horsepower, fuelType);
        this.cylinderCount = cylinderCount;
    }

    @Override
    public void boot() {
        System.out.println(engineNoiseGenerator.generateNoise(super.getFuelType(), this.cylinderCount,  super.getHorsepower()));
    }

}
