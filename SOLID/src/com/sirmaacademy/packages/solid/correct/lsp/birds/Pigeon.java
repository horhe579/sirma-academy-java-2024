package com.sirmaacademy.packages.solid.correct.lsp.birds;

public class Pigeon extends Bird{

    public Pigeon(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is flying... flap, flap.");
    }
}
