package com.sirmaacademy.packages.solid.correct.lsp.birds;

public class Ostrich extends Bird{

    public Ostrich(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " cannot fly... how sad.");
    }
}
