package com.sirma.classes.employeemanager;

import com.sirma.classes.employee.Position;
import com.sirma.classes.employee.Employee;
import com.sirma.classes.exceptions.EmployeeAlreadyExistsException;
import com.sirma.classes.exceptions.EmployeeNotFoundException;
import com.sirma.enums.Department;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CsvEmployeeManager {

    private final String filePath;

    public CsvEmployeeManager(String filePath) {
        this.filePath = filePath;
        initializeFile();
    }

    private void initializeFile() {
        File file = new File(this.filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error initializing file: " + this.filePath, e);
            }
        }
    }

    protected Employee addEmployee(Employee employee)
    {
        String employeeId = employee.getID().toString();
        if (getEmployeeWithID(employeeId) != null) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + employeeId + " already exists.");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath, true))) {
            //should be to csv string
            bw.write(employee.toString());
            bw.newLine();
            return employee;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //list employees from CSV
    protected List<Employee> listEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Employee> employees = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Id,Name,StartDate,EndDate,Department,Role,Salary")) {
                    continue;
                }
                Employee employee = parseEmployeeFromLine(line);
                employees.add(employee);
            }
            return (employees.isEmpty()) ? null : employees;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot read from nonexistent file with name " + filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //fire employee with id in csv
    protected void deleteEmployeeWithID(String employeeId) {
        if (getEmployeeWithID(employeeId) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
        }

        List<String> replacedLines = this.readAllFromFile().stream()
                .filter(l -> !(l.startsWith(employeeId + ",")))
                .collect(Collectors.toList());

        this.writeToFile(replacedLines);
    }

    //edit employee with id in csv
    //when editing employees the first row gets expanded for some unholy reason
    protected Employee editEmployeeWithID(Employee employee) {
        String employeeId = employee.getID().toString();
        if (getEmployeeWithID(employeeId) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
        }

        var replacedLines = this.readAllFromFile().stream()
                .map(l -> (l.startsWith(employeeId + ",")) ? employee.toString() : l)
                .collect(Collectors.toList());

        this.writeToFile(replacedLines);
        return employee;
    }

    protected Employee getEmployeeWithID(String employeeId) {
        List<Employee> employees = listEmployees();
        if(employees == null)
        {
            return null;
        }
        return employees.stream()
                .filter(e -> e.getID().toString().equals(employeeId))
                .findFirst().orElse(null);
    }

    //helper methods

    protected Employee parseEmployeeFromLine(String line) {
        //add some error handling, format checking
        //although if there is a problem in parsing there must be a problem in writing, so you are in fault
        //ID,Name,StartDate,EndDate,Department,Role,Salary
        String[] contents = line.split(",");
        UUID employeeID = UUID.fromString(contents[0]);
        String employeeName = contents[1];
        LocalDate startDate = (contents[2].equals("null")) ? null : LocalDate.parse(contents[2]);
        LocalDate endDate = (contents[3].equals("null")) ? null : LocalDate.parse(contents[3]);
        Department department = Department.valueOf(contents[4]);
        String role = contents[5];
        double salary = Double.parseDouble(contents[6]);
        Employee employee = new Employee(employeeID, employeeName, (startDate == null) ? null : new Position(department, role, salary, startDate, endDate));

        return employee;
    }

    private List<String> readAllFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            return br.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath))) {
            lines = lines.stream().filter(l -> !l.equals("Id,Name,StartDate,EndDate,Department,Role,Salary"))
                    .collect(Collectors.toList());
            for (String line : lines) {
                if (line != null) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
