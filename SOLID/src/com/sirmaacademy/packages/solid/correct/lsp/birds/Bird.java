package com.sirmaacademy.packages.solid.correct.lsp.birds;

public abstract class Bird implements Flyable {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
