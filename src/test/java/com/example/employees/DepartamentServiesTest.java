package com.example.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartamentServiesTest {

    @Mock
    private EmployeeServies employeeService;

    @InjectMocks
    private DepartmentServies departmentService;

    private Employee[] employees;

    @BeforeEach
    public void setUp() {
        employees = new Employee[10];
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
        when(employeeService.getEmployees()).thenReturn(employees);
    }

    @Test
    public void testGetMinSalary() {
        List<String> result = departmentService.getMinSalary((byte) 1);
        assertEquals(1, result.size());
        assertEquals("Employee{name='Екатерина', familyName='Иванова', fullName='Иванова Екатерина', departament=1, salary=41000}", result.get(0));
    }

    @Test
    public void testGetMaxSalary() {
        List<String> result = departmentService.getMaxSalary((byte) 1);
        assertEquals(1, result.size());
        assertEquals("Employee{name='Ivan', familyName='Ivanov', fullName='Ivanov Ivan', departament=1, salary=70000}", result.get(0));
    }

    @Test
    public void testGetMinSalaryNonExistentDepartment() {
        List<String> result = departmentService.getMinSalary((byte) 10);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetMaxSalaryNonExistentDepartment() {
        List<String> result = departmentService.getMaxSalary((byte) 10);
        assertEquals(0, result.size());
    }
}
