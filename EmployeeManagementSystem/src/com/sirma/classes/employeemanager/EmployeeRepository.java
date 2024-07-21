package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Employee;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.classes.exceptions.NoEmployeesException;

import java.util.List;

public class EmployeeRepository {
    //implement saving to database(csv file in this case)

    private CsvEmployeeManager manager;

    protected EmployeeRepository(String filePath) {
        this.manager = new CsvEmployeeManager(filePath);
    }

    //save employee|POST
    protected Employee createEmployee(Employee employee) {
        try {
            return this.manager.addEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsException(e.getMessage());
        }
    }

    //edit employee|PUT
    protected Employee updateEmployee(Employee employee) {
        try {
            return this.manager.editEmployeeWithID(employee);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    //remove employee|DELETE
    protected void deleteEmployee(String employeeID) {
        try {
            this.manager.deleteEmployeeWithID(employeeID);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException(e.getMessage());
        }
    }

    //get employee|GET{id}
    protected Employee getEmployee(String employeeId) {
        Employee employee = this.manager.getEmployeeWithID(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
        }
        return employee;
    }

    //get employees|GET
    protected List<Employee> getEmployees() {
        List<Employee> employees = this.manager.listEmployees();
        if (employees == null) {
            throw new NoEmployeesException("No employees.");
        }
        return employees;
    }

}
