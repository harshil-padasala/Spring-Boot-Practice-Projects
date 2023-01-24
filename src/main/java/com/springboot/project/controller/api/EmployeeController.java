package com.springboot.project.controller.api;

import com.springboot.project.entity.Employee;
import com.springboot.project.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);


    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee emp) {
        LOGGER.info("Saved new Employee Record.");
        return employeeService.saveEmployee(emp);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeByEmpId(@PathVariable Integer id) {
        return employeeService.getEmployeeByEmpId(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployeesRecord() {
        return employeeService.getAllEmployeesRecord();
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee emp) {
        return employeeService.updateEmployee(emp);
    }
}
