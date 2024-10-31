package com.example.employees;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentServies departmentServies;

    @Autowired
    public DepartmentController(DepartmentServies departmentServies) {
        this.departmentServies = departmentServies;
    }

    @GetMapping(path = "/max-salary")
    public List<String> findMaxSalary(@PathParam("departmentId") byte departmentId) {
        return departmentServies.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public List<String> findMinSalary(@PathParam("departmentId") byte departmentId) {
        return departmentServies.getMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public List<String> findAllEmployeeOnDepartament(@PathParam("departmentId") byte departmentId) {
        return departmentServies.printEmployeeList(departmentId);
    }
}
