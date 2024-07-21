package com.sirma.classes;

import com.sirma.classes.employee.Employee;

import java.util.List;
import java.util.UUID;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean hireEmployee()
    {
        //check if exists
        return this.employeeRepository.createEmployee();
    }

    public boolean fireEmployee(UUID employeeID)
    {
        //check if employee exists before firing
        return this.employeeRepository.deleteEmployee();
    }

    public boolean EditEmployee(Employee updatedEmployee)
    {
        //check if employee exists before updating
        return this.employeeRepository.updateEmployee();
    }

    public List<Employee> getEmployees()
    {
        return this.employeeRepository.getEmployees();
    }

    public Employee getEmployeeByID(UUID employeeID)
    {
        return this.employeeRepository.getEmployee(employeeID);
    }

}
