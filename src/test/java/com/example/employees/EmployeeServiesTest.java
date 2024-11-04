package com.example.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.employees.EmployeeServies.employees;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiesTest {
    @Autowired
    public EmployeeServies employeeServies;

    @Test
    void groupEmployeesTest(){
        assertEquals(employees, employees);
    }
}
