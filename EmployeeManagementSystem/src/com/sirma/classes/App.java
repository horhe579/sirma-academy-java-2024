package com.sirma.classes;

import com.sirma.classes.employeemanager.EmployeeManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager("C:\\Users\\Gesha\\Documents\\GitHub\\sirma-academy-java-2024\\EmployeeManagementSystem\\src\\com\\sirma\\pseudodatabase\\sirma.csv");
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (isRunning)
        {
            if(command.toLowerCase().equals("end"))
            {
                return;
            }
            manager.executeCommand(command);
            command = sc.nextLine();
        }
    }
}
