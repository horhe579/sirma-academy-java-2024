package com.sirma.classes;

import com.sirma.classes.employee.Employee;

import java.util.List;
import java.util.UUID;

public class EmployeeRepository {
    //implement saving to database(csv file in this case)


    //save employee|POST
    public boolean createEmployee()
    {
        return true;
    }

    //edit employee|PUT
    public boolean updateEmployee()
    {
        return true;
    }

    //remove employee|DELETE
    public boolean deleteEmployee()
    {
        return true;
    }

    //get employee|GET{id}
    public Employee getEmployee(UUID employeeID)
    {
        return null;
    }

    //get employees|GET
    public List<Employee> getEmployees()
    {
        return null;
    }

}
