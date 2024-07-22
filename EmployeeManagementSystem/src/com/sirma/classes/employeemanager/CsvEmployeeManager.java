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

// A class for manipulating .csv files to read and write Employee objects
public class CsvEmployeeManager {

    private final String filePath;

    public CsvEmployeeManager(String filePath) {
        this.filePath = filePath;
        initializeFile();
    }

    // Adds an employee to the .csv file
    // Throws EmployeeAlreadyExistsException if an employee with the same ID already exists
    protected Employee addEmployee(Employee employee) {
        String employeeId = employee.getID().toString();
        if (getEmployeeWithID(employeeId) != null) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + employeeId + " already exists.");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath, true))) {
            bw.write(employee.toString());
            bw.newLine();
            return employee;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Lists all employees from the .csv file
    // Returns a list of Employee objects or null if no entries are found
    protected List<Employee> listEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Employee> employees = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                Employee employee = parseEmployeeFromLine(line);
                employees.add(employee);
            }
            return employees.isEmpty() ? null : employees;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot read from nonexistent file: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Deletes an employee with the specified ID from the .csv file
    // Throws EmployeeNotFoundException if no employee with the given ID is found
    protected void deleteEmployeeWithID(String employeeId) {
        if (getEmployeeWithID(employeeId) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
        }

        List<String> remainingLines = readAllFromFile().stream()
                .filter(l -> !l.startsWith(employeeId + ","))
                .collect(Collectors.toList());

        writeToFile(remainingLines);
    }

    // Edits an employee with the specified ID in the .csv file
    // Throws EmployeeNotFoundException if no employee with the given ID is found
    // Returns the updated Employee object
    protected Employee editEmployeeWithID(Employee employee) {
        String employeeId = employee.getID().toString();
        if (getEmployeeWithID(employeeId) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
        }

        List<String> updatedLines = readAllFromFile().stream()
                .map(l -> l.startsWith(employeeId + ",") ? employee.toString() : l)
                .collect(Collectors.toList());

        writeToFile(updatedLines);
        return employee;
    }

    // Retrieves an employee with the specified ID from the .csv file
    // Returns the Employee object or null if not found
    protected Employee getEmployeeWithID(String employeeId) {
        List<Employee> employees = listEmployees();
        if (employees == null) {
            return null;
        }
        return employees.stream()
                .filter(e -> e.getID().toString().equals(employeeId))
                .findFirst().orElse(null);
    }

    // Initializes the .csv file if it does not exist
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

    // Parses an employee from a line in the .csv file
    // Returns an Employee object
    protected Employee parseEmployeeFromLine(String line) {
        // Assumes the line format is: ID,Name,StartDate,EndDate,Department,Role,Salary
        String[] contents = line.split(",");
        UUID employeeID = UUID.fromString(contents[0]);
        String employeeName = contents[1];
        LocalDate startDate = contents[2].equals("null") ? null : LocalDate.parse(contents[2]);
        LocalDate endDate = contents[3].equals("null") ? null : LocalDate.parse(contents[3]);
        Department department = Department.valueOf(contents[4]);
        String role = contents[5];
        double salary = Double.parseDouble(contents[6]);
        return new Employee(employeeID, employeeName, startDate == null ? null : new Position(department, role, salary, startDate, endDate));
    }

    // Reads all lines from the .csv file
    // Returns a list of strings, each representing a line in the file
    private List<String> readAllFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            return br.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Writes a list of strings to the .csv file
    // Each string is assumed to be a valid Employee.toString() representation
    private void writeToFile(List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath))) {
            for (String line : lines) {
                if (line != null && !line.isEmpty()) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
