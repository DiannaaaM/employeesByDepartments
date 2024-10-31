package com.example.employees;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


@Service
public class EmployeeServies {
    public static Employee[] employees = new Employee[10];

    public EmployeeServies() {
        employees[0] = new Employee( "Иван", "Иванов", (byte) 1, 50000 );
        employees[1] = new Employee( "Дмитрий", "Александров", (byte) 4, 15000 );
        employees[2] = new Employee( "Евгений", "Александров", (byte) 4, 55500 );
        employees[3] = new Employee( "Екатерина", "Иванова", (byte) 1, 41000 );
        employees[4] = new Employee( "Ivan", "Ivanov", (byte) 5, 50000 );
        employees[5] = new Employee( "Ivan", "Ivanov", (byte) 2, 50500 );
        employees[6] = new Employee( "Ivan", "Ivanov", (byte) 1, 70000 );
        employees[7] = new Employee( "Ivan", "Ivanov", (byte) 3, 90000 );
        employees[8] = new Employee( "Ivan", "Ivanov", (byte) 2, 20000 );
        employees[9] = new Employee( "Ivan", "Ivanov", (byte) 5, 10000 );
    }

    public static List<String> printEmployeeListAll() {
        List<String> ret = Arrays.stream(employees)
                .map(employee -> employee.toString())
                .collect(Collectors.toList());
        return ret;
    }
}
