package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.classes.exceptions.NoEmployeesException;

import java.util.List;

// A service class for managing Employee operations using EmployeeRepository
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    // Constructor to initialize EmployeeRepository
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Method to hire a new employee
    // Takes an Employee object as a parameter
    // Throws EmployeeAlreadyExistsException if the employee already exists
    public Employee hireEmployee(Employee employee) {
        try {
            return this.employeeRepository.createEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsException(e.getMessage());
        }
    }

    // Method to edit an existing employee
    // Takes an Employee object representing the updated employee as a parameter
    // Throws EmployeeNotFoundException if the employee does not exist
    public Employee editEmployee(Employee updatedEmployee) {
        try {
            return this.employeeRepository.updateEmployee(updatedEmployee);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    // Method to retrieve all employees
    // Returns a list of Employee objects
    // Throws NoEmployeesException if no employees are found
    public List<Employee> getEmployees() {
        try {
            return this.employeeRepository.getEmployees();
        } catch (NoEmployeesException e) {
            throw new NoEmployeesException(e.getMessage());
        }
    }

    // Method to retrieve an employee by ID
    // Takes a String representing the employee ID as a parameter
    // Returns an Employee object
    // Throws EmployeeNotFoundException if the employee does not exist
    public Employee getEmployeeByID(String employeeID) {
        try {
            return this.employeeRepository.getEmployee(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    // Method to fire an employee by ID
    // Takes a String representing the employee ID as a parameter
    // Throws EmployeeNotFoundException if the employee does not exist
    public void fireEmployee(String employeeID) {
        try {
            this.employeeRepository.deleteEmployee(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }
}
