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
    private EmployeeServies employeeService;

    public Map<Byte, List<Employee>> groupEmployeesByDepartment(byte departmentId) {
        return Arrays.stream( employeeService.getEmployees() )
                .filter( employee -> employee != null && employee.getDepartament() == departmentId )
                .collect( Collectors.groupingBy( Employee::getDepartament ) );
    }

    public List<String> getMinSalary(byte departmentId) {
        OptionalInt minSalary = Arrays.stream( employeeService.getEmployees() )
                .filter( employee -> employee != null && employee.getDepartament() == departmentId )
                .mapToInt( Employee::getSalary )
                .min();

        if (minSalary.isPresent()) {
            return Arrays.stream( employeeService.getEmployees() )
                    .filter( employee -> employee != null && employee.getDepartament() == departmentId && employee.getSalary() == minSalary.getAsInt() )
                    .map( Employee::toString )
                    .collect( Collectors.toList() );
        } else {
            return List.of();
        }
    }

    public List<String> getMaxSalary(byte departmentId) {
        OptionalInt maxSalary = Arrays.stream( employeeService.getEmployees() )
                .filter( employee -> employee != null && employee.getDepartament() == departmentId )
                .mapToInt( Employee::getSalary )
                .max();

        if (maxSalary.isPresent()) {
            return Arrays.stream( employeeService.getEmployees() )
                    .filter( employee -> employee != null && employee.getDepartament() == departmentId && employee.getSalary() == maxSalary.getAsInt() )
                    .map( Employee::toString )
                    .collect( Collectors.toList() );
        } else {
            return List.of();
        }
    }
}
