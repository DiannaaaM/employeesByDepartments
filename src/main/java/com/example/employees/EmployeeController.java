package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class EmployeeController {
    private final EmployeeServies employeeServies;

    @Autowired
    public EmployeeController(EmployeeServies employeeServies) {
        this.employeeServies = employeeServies;
    }

    @GetMapping(path = "/all-grouped")
    public Map<Byte, List<Employee>> allEmployees() {
        return employeeServies.groupEmployees();
    }
}
