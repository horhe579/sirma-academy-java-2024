package com.sirma.classes.employee;

import com.sirma.enums.Department;
import com.sirma.interfaces.Job;

import java.time.LocalDate;

public class Position implements Job {
    private Department department;
    private String role;
    private double salary;
    private LocalDate started = null;
    private LocalDate ended = null;

    public Position(Department department, String role, double salary) {
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.started = LocalDate.now();
    }

    public Position(Department department, String role, double salary, LocalDate started, LocalDate ended) {
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.started = started;
        this.ended = ended;
    }

    public Department getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getStarted() {
        return started;
    }

    public LocalDate getEnded() {
        return ended;
    }

    public void setEnded() {
        this.ended = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.join(",",
                this.started != null ? this.started.toString() : "null",
                this.ended != null ? this.ended.toString() : "null",
                this.department != null ? this.department.toString() : "null",
                this.role != null ? this.role : "null",
                String.valueOf(this.salary));
    }
}
