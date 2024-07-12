package com.sirmaacademy.packages.solid.correct.lsp;

public interface CombustionCarNoiseGenerator extends CarNoiseGenerator{
    String generateNoise(FuelType fuelType, int cylinderCount, int horsepower);
}
