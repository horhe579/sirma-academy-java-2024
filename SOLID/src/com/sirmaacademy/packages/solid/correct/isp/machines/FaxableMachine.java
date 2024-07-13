package com.sirmaacademy.packages.solid.correct.isp.machines;

public class FaxableMachine implements Faxable{
    @Override
    public void fax() {
        System.out.println(this.getClass().getSimpleName() + " is faxing... fax, fax.");
    }
}
