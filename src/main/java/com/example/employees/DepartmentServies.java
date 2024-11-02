package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class DepartmentServies {

    @Autowired
    private EmployeeServies employeeServies;

    public List<String> printEmployeeList(byte departmentId) {
        return Arrays.stream( EmployeeServies.employees )
                .filter(employee -> employee.getDepartament() == departmentId)
                .map(Employee::toString)
                .collect(Collectors.toList());
    }

    public List<String> getMinSalary(byte departmentId) {
        OptionalInt minSalary = Arrays.stream( EmployeeServies.employees )
                .filter(employee -> employee.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .min();

        return Arrays.stream( EmployeeServies.employees )
                .filter(employee -> employee.getDepartament() == departmentId && employee.getSalary() == minSalary.getAsInt())
                .map(Employee::toString)
                .collect(Collectors.toList());
    }

    public List<String> getMaxSalary(byte departmentId) {
        OptionalInt maxSalary = Arrays.stream( EmployeeServies.employees )
                .filter(employee -> employee.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .max();

        return (List<String>) Arrays.stream( EmployeeServies.employees )
                .filter(employee -> employee.getDepartament() == departmentId && employee.getSalary() == maxSalary.getAsInt());}}
