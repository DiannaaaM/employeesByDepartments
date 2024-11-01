package com.example.employees;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static com.example.employees.EmployeeServies.employees;

@Service
public class DepartmentServies {

    public static List<String> printEmployeeList(byte departanentId) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId)
                .map(Employee::toString)
                .collect(Collectors.toList());
    }

    public static List<String> getMinSalary(byte departanentId) {
        OptionalInt minSalary = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId)
                .mapToInt(Employee::getSalary)
                .min();
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId && employee.getSalary() == minSalary.getAsInt())
                .map(Employee::toString)
                .collect(Collectors.toList());
    }

    public static List<String> getMaxSalary(byte departanentId) {
        OptionalInt maxSalary = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId)
                .mapToInt(Employee::getSalary)
                .max();

        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId && employee.getSalary() == maxSalary.getAsInt())
                .map(Employee::toString)
                .collect(Collectors.toList());
    }
}