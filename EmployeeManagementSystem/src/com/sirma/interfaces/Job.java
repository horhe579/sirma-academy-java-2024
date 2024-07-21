package com.sirma.interfaces;

import com.sirma.enums.Department;

public interface Job {
    Department getDepartment();
    String getRole();
    double getSalary();
}
