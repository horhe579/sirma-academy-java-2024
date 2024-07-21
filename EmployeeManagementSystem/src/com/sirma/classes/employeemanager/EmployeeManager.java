package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.employee.Position;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.classes.exceptions.NoEmployeesException;
import com.sirma.enums.Department;

import java.io.IOException;
import java.util.*;

public class EmployeeManager {
    private static final Map<String, Integer> VALID_COMMANDS = new HashMap<>();
    private String filePath;
    private EmployeeService employeeService;

    static {
        VALID_COMMANDS.put("Add Employee", 4);
        VALID_COMMANDS.put("Add", 4);
        VALID_COMMANDS.put("Edit Employee", 4);
        VALID_COMMANDS.put("Edit", 4);
        VALID_COMMANDS.put("Fire Employee", 1);
        VALID_COMMANDS.put("Fire", 1);
        VALID_COMMANDS.put("Get Employee", 1);
        VALID_COMMANDS.put("Get", 1);
        VALID_COMMANDS.put("Get Employees", 0);
    }

    public EmployeeManager(String filePath)
    {
        EmployeeRepository repository = new EmployeeRepository(filePath);
        this.employeeService = new EmployeeService(repository);
    }

    public void executeCommand(String command)
    {
        switch (command)
        {
            case "Add Employee":
            case "Add":
                try(Scanner sc = new Scanner(System.in))
                {
                    String[] fields = sc.nextLine().split("[, ]+");
                    this.handleAddEmployee(fields[0], fields[1], fields[2], fields[3]);
                    break;
                }
                catch (IllegalArgumentException e)
                {
                    System.err.println(e);
                }
                catch (EmployeeAlreadyExistsException e)
                {
                    System.err.println(e);
                }
            case "Edit Employee":
            case "Edit":
                try(Scanner sc = new Scanner(System.in))
                {
                    String employeeId = sc.nextLine();
                    String[] fields = sc.nextLine().split("[, ]+");
                    this.handleEditEmployee(employeeId, fields[0], fields[1], fields[2], fields[3]);
                    break;
                }
                catch (IllegalArgumentException e)
                {
                    System.err.println(e);
                }
                catch (EmployeeNotFoundException e)
                {
                    System.err.println(e);
                }
            case "Fire Employee":
            case "Fire":
                try(Scanner sc = new Scanner(System.in))
                {
                    String employeeId = sc.nextLine();
                    this.handleFireEmployee(employeeId);
                    break;
                }
                catch (EmployeeNotFoundException e)
                {
                    System.err.println(e.getMessage());
                }
            case "Get Employee":
            case "Get":
                try(Scanner sc = new Scanner(System.in))
                {
                    String employeeId = sc.nextLine();
                    this.handleGetEmployee(employeeId);
                    break;
                }
                catch (EmployeeNotFoundException e)
                {
                    System.err.println(e.getMessage());
                }
            case "Get Employees":
                this.handleListEmployees();
                break;
            default:
                System.err.println("Unknown command: " + command);
        }

    }


    public String getFilePath()
    {
        return this.filePath;
    }

    //handling methods for all the service methods assuming the parameters are valid

    private void handleAddEmployee(String name, String department, String role, String salary)
    {
        Department parsedDepartment = Department.valueOf(department.trim().toUpperCase(Locale.ROOT));
        double parsedSalary = Double.parseDouble(salary);
        Position position = new Position(Department.valueOf(department.trim().toUpperCase(Locale.ROOT)), role, Double.parseDouble(salary));
        Employee employee = new Employee(name, position);
        try
        {
            System.out.println("Added employee " + this.employeeService.hireEmployee(employee).toString());
        }
        catch (EmployeeAlreadyExistsException e)
        {
            throw new EmployeeAlreadyExistsException(e.getMessage());
        }
    }

    private void handleEditEmployee(String employeeID, String name, String department, String role, String salary)
    {
        Department parsedDepartment = Department.valueOf(department.trim().toUpperCase(Locale.ROOT));
        double parsedSalary = Double.parseDouble(salary);
        Position position = new Position(Department.valueOf(department.trim().toUpperCase(Locale.ROOT)), role, Double.parseDouble(salary));
        Employee employee = new Employee(UUID.fromString(employeeID), name, position);
        try
        {
            System.out.println("Edited employee " + this.employeeService.editEmployee(employee).toString());
        }
        catch (EmployeeNotFoundException e)
        {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    private void handleFireEmployee(String employeeID)
    {
        try {
            this.employeeService.fireEmployee(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    private void handleListEmployees()
    {
        try {
            this.employeeService.getEmployees().stream().forEach(e -> System.out.println(e.toString()));
        } catch (NoEmployeesException e) {
            System.err.println(e.getMessage());
        }
    }

    private void handleGetEmployee(String employeeID)
    {
        System.out.println(this.employeeService.getEmployeeByID(employeeID).toString());
    }
}
