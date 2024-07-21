package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.employee.Position;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
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
                Scanner sc = new Scanner(System.in);
                String[] fields = sc.nextLine().split("[, ]+");
                String name = fields[0];
                String department = fields[1];
                String role = fields[2];
                String salary = fields[3];
                this.handleAddEmployee(name, department, role, salary);
                break;
            case "Edit Employee":
            case "Edit":
                //employeeService.editEmployee()
                break;
            case "Fire Employee":
            case "Fire":
                //employeeService.fireEmployee();
                break;
            case "Get Employee":
            case "Get":
                //employeeService.getEmployeeByID();
                break;
            case "Get Employees":
                employeeService.getEmployees().stream().forEach(e -> System.out.println(e.toString()));
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
        Position position = new Position(Department.valueOf(department.trim().toUpperCase(Locale.ROOT)), role, Double.parseDouble(salary));
        Position position1 = new Position(Department.IT, "Manager", 2000);
        Employee employee = new Employee(name, position1);
        try
        {
            System.out.println("Added employee " + this.employeeService.hireEmployee(employee).toString());
        }
        catch (EmployeeAlreadyExistsException e)
        {
            System.err.println(e);
        }
    }



}
