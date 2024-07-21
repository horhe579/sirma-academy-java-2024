package com.sirma.classes.employee;

import com.sirma.interfaces.Employable;

import java.util.UUID;

public class Employee implements Employable{
    private UUID ID;
    private String name;
    private Position position;
    private boolean isEmployed = false;

    public Employee() {
    }

    public Employee(UUID ID, String name, Position position) {
        this.ID = ID;
        this.name = name;
        this.position = position;
        this.isEmployed = true;
    }

    public Employee(String name, Position position) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.position = position;
        this.isEmployed = true;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    //returns null if unemployed, else returns the salary in the job
    @Override
    public double getSalary() {
        return (this.position == null) ? null : this.position.getSalary();
    }

    public Position getJob() {
        return position;
    }

    public void setJob(Position position) {
        this.position = position;
    }

    public void setEmployed(boolean isEmployed)
    {
        this.isEmployed = isEmployed;
    }

    @Override
    public String toString() {
        return String.join(",",
                this.ID.toString(),
                this.name,
                this.position.toString());
    }
}
