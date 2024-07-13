package com.sirmaacademy.packages.solid.correct.isp.machines;

public class GreatMachine implements Scannable, Faxable, Printable{
    @Override
    public void fax() {
        System.out.println(this.getClass().getSimpleName() + " is faxing... fax, fax.");
    }

    @Override
    public void print(Object information) {
        System.out.println(information.toString());
    }

    @Override
    public void scan(Object information) {
        System.out.println(this.getClass().getSimpleName() + " is scanning... scan, scan.");
        System.out.println(this.getClass().getSimpleName() + " scanned " + information.toString());
    }
}
