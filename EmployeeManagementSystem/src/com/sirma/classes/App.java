package com.sirma.classes;

import com.sirma.classes.employeemanager.EmployeeManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\EmployeeManagementSystem\\src\\com\\sirma\\pseudodatabase\\sirma.csv");
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        printWelcomeMessage();

        while (isRunning) {
            System.out.println("Enter a command:");
            String command = sc.nextLine().trim();

            if (command.equalsIgnoreCase("end")) {
                System.out.println("Exiting the program...");
                isRunning = false;
            } else {
                try {
                    manager.executeCommand(command);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid command or input: " + e.getMessage());
                }
            }
        }

        sc.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to the Employee Management System!");
        System.out.println("Available commands:");
        System.out.println(" - Add Employee");
        System.out.println(" - Edit Employee");
        System.out.println(" - Fire Employee");
        System.out.println(" - Get Employee");
        System.out.println(" - Get Employees");
        System.out.println(" - End (to exit the program)");
    }
}
