package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.classes.exceptions.NoEmployeesException;

import java.util.List;

// A repository class for managing Employee objects using a CsvEmployeeManager
public class EmployeeRepository {

    private CsvEmployeeManager manager;

    protected EmployeeRepository(String filePath) {
        this.manager = new CsvEmployeeManager(filePath);
    }

    // Saves a new employee to the repository
    // Throws EmployeeAlreadyExistsException if the employee already exists
    protected Employee createEmployee(Employee employee) {
        try {
            return this.manager.addEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsException(e.getMessage());
        }
    }

    // Updates an existing employee in the repository
    // Throws EmployeeNotFoundException if the employee does not exist
    protected Employee updateEmployee(Employee employee) {
        try {
            return this.manager.editEmployeeWithID(employee);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    // Deletes an employee from the repository
    // Throws EmployeeNotFoundException if the employee does not exist
    protected void deleteEmployee(String employeeID) {
        try {
            this.manager.deleteEmployeeWithID(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    // Retrieves an employee by ID from the repository
    // Throws EmployeeNotFoundException if the employee does not exist
    protected Employee getEmployee(String employeeId) {
        Employee employee = this.manager.getEmployeeWithID(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
        }
        return employee;
    }

    // Retrieves all employees from the repository
    // Throws NoEmployeesException if no employees are found
    protected List<Employee> getEmployees() {
        List<Employee> employees = this.manager.listEmployees();
        if (employees == null) {
            throw new NoEmployeesException("No employees.");
        }
        return employees;
    }
}
