package com.sirmaacademy.packages.solid.correct.lsp.engines;

public class ElectricEngineNoiseGenerator implements CarNoiseGenerator{
    @Override
    public String generateNoise(int horsepower) {
        StringBuilder carNoise = new StringBuilder(determineNoiseStrength(horsepower));
        carNoise.append("with " + horsepower + " electric horses");
        return carNoise.toString();
    }

    private String determineNoiseStrength(int horsepower) {
        if(horsepower <= 200)
        {
            return "Whirr...";
        }
        return "Whoooosh...";
    }
}
