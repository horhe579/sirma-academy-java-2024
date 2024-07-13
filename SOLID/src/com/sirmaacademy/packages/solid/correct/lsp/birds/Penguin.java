package com.sirmaacademy.packages.solid.correct.lsp.birds;

public class Penguin extends Bird{

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " cannot fly... how sad.");
    }
}
