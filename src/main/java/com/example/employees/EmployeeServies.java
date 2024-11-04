package com.example.employees;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class EmployeeServies {
    public static Employee[] employees = new Employee[10];

    public EmployeeServies(Employee[] employees) {
        EmployeeServies.employees[0] = new Employee( "Иван", "Иванов", (byte) 1, 50000 );
        EmployeeServies.employees[1] = new Employee( "Дмитрий", "Александров", (byte) 4, 15000 );
        EmployeeServies.employees[2] = new Employee( "Евгений", "Александров", (byte) 4, 55500 );
        EmployeeServies.employees[3] = new Employee( "Екатерина", "Иванова", (byte) 1, 41000 );
        EmployeeServies.employees[4] = new Employee( "Ivan", "Ivanov", (byte) 5, 50000 );
        EmployeeServies.employees[5] = new Employee( "Ivan", "Ivanov", (byte) 2, 50500 );
        EmployeeServies.employees[6] = new Employee( "Ivan", "Ivanov", (byte) 1, 70000 );
        EmployeeServies.employees[7] = new Employee( "Ivan", "Ivanov", (byte) 3, 90000 );
        EmployeeServies.employees[8] = new Employee( "Ivan", "Ivanov", (byte) 2, 20000 );
        EmployeeServies.employees[9] = new Employee( "Ivan", "Ivanov", (byte) 5, 10000 );
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public static List<String> printEmployeeListAll() {
        List<String> ret = Arrays.stream(employees)
                .map( Employee::toString )
                .collect(Collectors.toList());
        return ret;
    }
    public static Map<Byte, List<Employee>> groupEmployees () {
        return (Map<Byte, List<Employee>>) Arrays.stream(employees);
    }
}
