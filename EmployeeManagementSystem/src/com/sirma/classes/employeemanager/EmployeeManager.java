package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.employee.Position;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.classes.exceptions.NoEmployeesException;
import com.sirma.enums.Department;

import java.util.*;

public class EmployeeManager {
    private static final Map<String, Integer> VALID_COMMANDS = new HashMap<>();
    private String filePath;
    private EmployeeService employeeService;

    static {
        VALID_COMMANDS.put("add employee", 4);
        VALID_COMMANDS.put("add", 4);
        VALID_COMMANDS.put("edit employee", 4);
        VALID_COMMANDS.put("edit", 4);
        VALID_COMMANDS.put("fire employee", 1);
        VALID_COMMANDS.put("fire", 1);
        VALID_COMMANDS.put("get employee", 1);
        VALID_COMMANDS.put("get", 1);
        VALID_COMMANDS.put("get employees", 0);
    }

    public EmployeeManager(String filePath) {
        this.filePath = filePath;
        EmployeeRepository repository = new EmployeeRepository(filePath);
        this.employeeService = new EmployeeService(repository);
    }

    public void executeCommand(String command) {
        Scanner sc = new Scanner(System.in);
        command = command.toLowerCase();

        switch (command) {
            case "add employee":
            case "add":
                System.out.println("Enter the employee information in the following format: NAME, DEPARTMENT, ROLE, SALARY");
                try {
                    String[] fields = sc.nextLine().split("[, ]+");
                    this.handleAddEmployee(fields[0], fields[1], fields[2], fields[3]);
                } catch (IllegalArgumentException | EmployeeAlreadyExistsException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case "edit employee":
            case "edit":
                System.out.println("Enter the ID of the employee to edit:");
                try {
                    String employeeId = sc.nextLine();
                    System.out.println("Enter the updated employee information in the following format: NAME, DEPARTMENT, ROLE, SALARY");
                    String[] fields = sc.nextLine().split("[, ]+");
                    this.handleEditEmployee(employeeId, fields[0], fields[1], fields[2], fields[3]);
                } catch (IllegalArgumentException | EmployeeNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case "fire employee":
            case "fire":
                System.out.println("Enter the ID of the employee to fire:");
                try {
                    String employeeId = sc.nextLine();
                    this.handleFireEmployee(employeeId);
                } catch (EmployeeNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case "get employee":
            case "get":
                System.out.println("Enter the ID of the employee to retrieve:");
                try {
                    String employeeId = sc.nextLine();
                    this.handleGetEmployee(employeeId);
                } catch (EmployeeNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case "get employees":
                this.handleListEmployees();
                break;
            default:
                System.err.println("Unknown command: " + command);
                break;
        }
    }

    public String getFilePath() {
        return this.filePath;
    }

    // Handling methods for all the service methods assuming the parameters are valid
    private void handleAddEmployee(String name, String department, String role, String salary) {
        try {
            Department parsedDepartment = parseDepartment(department);
            double parsedSalary = parseSalary(salary);
            Position position = new Position(parsedDepartment, role, parsedSalary);
            Employee employee = new Employee(name, position);
            System.out.println("Added employee " + this.employeeService.hireEmployee(employee).toString());
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsException(e.getMessage());
        }
    }

    private void handleEditEmployee(String employeeID, String name, String department, String role, String salary) {
        try {
            Department parsedDepartment = parseDepartment(department);
            double parsedSalary = parseSalary(salary);
            Position position = new Position(parsedDepartment, role, parsedSalary);
            Employee employee = new Employee(UUID.fromString(employeeID), name, position);
            System.out.println("Edited employee " + this.employeeService.editEmployee(employee).toString());
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    private void handleFireEmployee(String employeeID) {
        try {
            this.employeeService.fireEmployee(employeeID);
            System.out.println("Fired employee with ID " + employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    private void handleListEmployees() {
        try {
            List<Employee> employees = this.employeeService.getEmployees();
            employees.forEach(e -> System.out.println(e.toString()));
        } catch (NoEmployeesException e) {
            throw new NoEmployeesException(e.getMessage());
        }
    }

    private void handleGetEmployee(String employeeID) {
        try {
            System.out.println(this.employeeService.getEmployeeByID(employeeID).toString());
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    // Helper methods for validation
    private Department parseDepartment(String department) {
        try {
            return Department.valueOf(department.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid department: " + department);
        }
    }

    private double parseSalary(String salary) {
        try {
            return Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid salary: " + salary);
        }
    }
}
