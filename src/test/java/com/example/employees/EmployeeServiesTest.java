package com.example.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.employees.EmployeeServies.employees;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiesTest {
    @Autowired
    public EmployeeServies employeeServies;

    @BeforeEach
    public void setUp() {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иван", "Иванов", (byte) 1, 50000);
        employees[1] = new Employee("Дмитрий", "Александров", (byte) 4, 15000);
        employees[2] = new Employee("Евгений", "Александров", (byte) 4, 55500);
        employees[3] = new Employee("Екатерина", "Иванова", (byte) 1, 41000);
        employees[4] = new Employee("Ivan", "Ivanov", (byte) 5, 50000);
        employees[5] = new Employee("Ivan", "Ivanov", (byte) 2, 50500);
        employees[6] = new Employee("Ivan", "Ivanov", (byte) 1, 70000);
        employees[7] = new Employee("Ivan", "Ivanov", (byte) 3, 90000);
        employees[8] = new Employee("Ivan", "Ivanov", (byte) 2, 20000);
        employees[9] = new Employee("Ivan", "Ivanov", (byte) 5, 10000);
        employeeServies = new EmployeeServies(employees);
    }

    @Test
    public void testGetEmployees() {
        Employee[] employees = employeeServies.getEmployees();
        assertEquals(10, employees.length);
        assertEquals("Иван", employees[0].getName());
        assertEquals("Дмитрий", employees[1].getName());
    }

    @Test
    public void testPrintEmployeeListAll() {
        List<String> result = EmployeeServies.printEmployeeListAll();
        assertEquals(10, result.size());
        assertEquals("Employee{name='Иван', familyName='Иванов', fullName='Иванов Иван', departament=1, salary=50000}", result.get(0));
        assertEquals("Employee{name='Дмитрий', familyName='Александров', fullName='Александров Дмитрий', departament=4, salary=15000}", result.get(1));
    }
}
