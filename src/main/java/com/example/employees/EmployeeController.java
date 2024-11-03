package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class EmployeeController {
    private final EmployeeServies employeeServies;

    @Autowired
    public EmployeeController(EmployeeServies employeeServies) {
        this.employeeServies = employeeServies;
    }

    @GetMapping(path = "/all")
    public List<String> allEmployees() {
        return employeeServies.printEmployeeListAll();
    }
}
