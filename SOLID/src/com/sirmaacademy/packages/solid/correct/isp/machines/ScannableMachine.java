package com.sirmaacademy.packages.solid.correct.isp.machines;

public class ScannableMachine implements Scannable{

    @Override
    public void scan(Object information) {
        System.out.println(this.getClass().getSimpleName() + " is scanning... scan, scan.");
        System.out.println(this.getClass().getSimpleName() + " scanned " + information.toString());
    }
}
