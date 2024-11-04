package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static com.example.employees.EmployeeServies.employees;

@Service
public class DepartmentServies {

    @Autowired
    private EmployeeServies employeeServies;

//    public List<String> printEmployeeList(byte departmentId) {
//        return Arrays.stream( employees )
//                .filter(employee -> employee.getDepartament() == departmentId)
//                .map(Employee::toString)
//                .collect(Collectors.toList());
//    }

    public static Map<Byte, List<Employee>> groupEmployeesByDepartment(byte departmentId) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }

    public List<String> getMinSalary(byte departmentId) {
        OptionalInt minSalary = Arrays.stream( employees )
                .filter(employee -> employee.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .min();

        return Arrays.stream( employees )
                .filter(employee -> employee.getDepartament() == departmentId && employee.getSalary() == minSalary.getAsInt())
                .map(Employee::toString)
                .collect(Collectors.toList());
    }

    public List<String> getMaxSalary(byte departmentId) {
        OptionalInt maxSalary = Arrays.stream( employees )
                .filter(employee -> employee.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .max();

        return (List<String>) Arrays.stream( employees )
                .filter(employee -> employee.getDepartament() == departmentId && employee.getSalary() == maxSalary.getAsInt());}}
