package com.sirmaacademy.packages.solid.correct.isp.machines;

public class PrintableMachine implements Printable{

    @Override
    public void print(Object information) {
        System.out.println(information.toString());
    }
}
