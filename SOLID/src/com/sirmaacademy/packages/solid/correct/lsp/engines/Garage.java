package com.sirmaacademy.packages.solid.correct.lsp.engines;

public class Garage {


    public void main(String[] args) {
        CombustionEngine v10 = new CombustionEngine(600, FuelType.GASOLINE, 10);
        CombustionEngine v8 = new CombustionEngine(300, FuelType.DIESEL, 8);
        CombustionEngine i4 = new CombustionEngine(140, FuelType.DIESEL, 4);
        //CombustionEngine i3 = new CombustionEngine(50, FuelType.ELECTRICITY, 3);
        ElectricEngine teslaEngine = new ElectricEngine(600);
        ElectricEngine porscheTaycanEngine = new ElectricEngine(700);
        ElectricEngine golfEngine = new ElectricEngine(100);

        v10.boot();
        v8.boot();
        i4.boot();
        //i3.boot();
        teslaEngine.boot();
        porscheTaycanEngine.boot();
        golfEngine.boot();
    }
}
