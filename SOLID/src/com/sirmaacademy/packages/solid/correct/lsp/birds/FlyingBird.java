package com.sirmaacademy.packages.solid.correct.lsp.birds;

public class FlyingBird extends Bird implements Flyable{

    public FlyingBird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " is flying... flap, flap.");
    }
}
