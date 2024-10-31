package com.example.employees;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;


@Service
public class EmployeeServies {
    public static Employee[] employees = new Employee[10];

    public EmployeeServies() {
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
    }

    public static String printEmployeeList(byte departanentId) {
        String result = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId)
                .map(Employee::toString)
                .collect(Collectors.joining(", "));
        return result;
    }

    public static String printEmployeeListAll() {
//        Optional EmployeeList = Optional.of(Arrays.stream(employees));
//        return EmployeeList.toString();
        String result = Arrays.stream(employees)
                .map(Employee::toString)
                .collect(Collectors.joining(", \""));
        return result;
    }

    public static String getMinSalary(byte departanentId) {
        OptionalInt minSalary = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId)
                .mapToInt(Employee::getSalary)
                .min();
        String result = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId && employee.getSalary() == minSalary.getAsInt())
                .map(Employee::toString)
                .collect(Collectors.joining(", "));
        return result;
    }

    public static String getMaxSalary(byte departanentId) {
        OptionalInt maxSalary = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId)
                .mapToInt(Employee::getSalary)
                .max();

        String result = Arrays.stream(employees)
                .filter(employee -> employee.getDepartament() == departanentId && employee.getSalary() == maxSalary.getAsInt())
                .map(Employee::toString)
                .collect(Collectors.joining(", "));
        return result;

    }
}
