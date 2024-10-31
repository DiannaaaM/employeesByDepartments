package com.example.employees;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
public class EmployeeController {
    private final EmployeeServies employeeServies;

    @Autowired
    public EmployeeController(EmployeeServies employeeServies) {
        this.employeeServies = employeeServies;
    }

    @GetMapping(path = "/max-salary")
    public String findMaxSalary(@PathParam("departmentId") byte departmentId) {
        return employeeServies.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public String findMinSalary(@PathParam("departmentId") byte departmentId) {
        return employeeServies.getMinSalary(departmentId);
    }

    @GetMapping(path = "/al")
    public String findAllEmployeeOnDepartament(@PathParam("departmentId") byte departmentId) {
        return (String) employeeServies.printEmployeeList(departmentId);
    }

    @GetMapping(path = "/all")
    public String allEmployees() {
        return employeeServies.printEmployeeListAll();
    }
}
