package com.sirmaacademy.packages.solid.correct.lsp;

public class CombustionEngineNoiseGenerator implements CombustionCarNoiseGenerator{
    @Override
    public String generateNoise(FuelType fuelType, int cylinderCount, int horsepower) {
        String strength = determineNoiseStrength(cylinderCount, horsepower);
        switch (fuelType) {
            case GASOLINE:
                return "Vroom Vroom! Gasoline engine with "  + horsepower + " horsepower. " + strength;
            case DIESEL:
                return "Rumble Rumble! Diesel engine with "  + horsepower + " horsepower. " + strength;
            default:
                return "Fuel type not supported for this combustion engine.";
        }
    }

    @Override
    public String generateNoise(int horsepower) {
        return "Brrr... with 4 cylinders and " + horsepower + "horsepower";
    }

    private String determineNoiseStrength(int cylinderCount, int horsepower) {
        boolean isPowerful = isPowerful(horsepower);
        switch (cylinderCount) {
            case 4:
                return isPowerful ? "Roar! This is a powerful 4-cylinder engine!" : "Purr... A smooth but less powerful 4-cylinder engine.";
            case 6:
                return isPowerful ? "Rumble! A strong 6-cylinder engine!" : "Hum... A decent 6-cylinder engine.";
            case 8:
                return isPowerful ? "Growl! A mighty 8-cylinder engine!" : "Buzz... An average 8-cylinder engine.";
            case 10:
                return isPowerful ? "Thunder! An impressive 10-cylinder engine!" : "Whir... A standard 10-cylinder engine.";
            case 12:
                return isPowerful ? "Blast! A beastly 12-cylinder engine!" : "Murmur... A less aggressive 12-cylinder engine.";
            default:
                return "Unknown engine configuration.";
        }
    }

    private boolean isPowerful(int horsepower) {
        return horsepower > 200; // Example threshold, adjust as needed
    }
}
