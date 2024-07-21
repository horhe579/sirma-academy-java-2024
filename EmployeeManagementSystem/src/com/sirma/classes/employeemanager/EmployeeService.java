package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.classes.exceptions.NoEmployeesException;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee hireEmployee(Employee employee) {
        //check if exists
        try {
            return this.employeeRepository.createEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsException(e.getMessage());
        }
    }

    public Employee editEmployee(Employee updatedEmployee) {
        //check if employee exists before updating
        try {
            return this.employeeRepository.updateEmployee(updatedEmployee);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    public List<Employee> getEmployees() {
        try {
            return this.employeeRepository.getEmployees();
        } catch (NoEmployeesException e) {
            throw new NoEmployeesException(e.getMessage());
        }
    }

    public Employee getEmployeeByID(String employeeID) {
        try {
            return this.employeeRepository.getEmployee(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    public void fireEmployee(String employeeID) {
        //check if employee exists before firing
        try {
            this.employeeRepository.deleteEmployee(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }
}
