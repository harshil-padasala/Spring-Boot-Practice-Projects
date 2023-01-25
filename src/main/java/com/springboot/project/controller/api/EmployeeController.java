package com.springboot.project.controller.api;

import com.springboot.project.entity.Employee;
import com.springboot.project.error.EmployeeNotFoundException;
import com.springboot.project.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee emp1;
        try {
            emp1 = employeeService.saveEmployee(emp);
            LOGGER.info("Saved new Employee Record.");
            return ResponseEntity.of(Optional.of(emp1));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/employee/{emp_id}")
    public ResponseEntity<Optional<Employee>> getEmployeeByEmpId(@PathVariable Long emp_id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeService.getEmployeeByEmpId(emp_id);
        if (employee.isEmpty()) {
            LOGGER.info("Requested with invalid empId: " + emp_id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LOGGER.info("Returned Employee record with id: " + emp_id);
        return ResponseEntity.of(Optional.of(employee));
    }

    @GetMapping("/employees")
    public ResponseEntity<Optional<List<Employee>>> getAllEmployeesRecord() {
        Optional<List<Employee>> listEmp = employeeService.getAllEmployeesRecord();

        if (listEmp.isEmpty()) {
            LOGGER.info("No Employees Found...");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LOGGER.info("Returned All Employee records");
        return ResponseEntity.of(Optional.of(listEmp));
    }

    @PutMapping("/employee/{emp_id}")
    public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable Long emp_id, @RequestBody Employee emp) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeService.getEmployeeByEmpId(emp_id);
        if (employee.isEmpty()) {
            LOGGER.info("Requested with invalid empId: " + emp_id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        employeeService.updateEmployee(emp);
        LOGGER.info("Updated Employee Record with empId: " + emp_id);
        employee = employeeService.getEmployeeByEmpId(emp_id);
        return ResponseEntity.of(Optional.of(employee));
    }


    @DeleteMapping("/employee/{emp_id}")
    public ResponseEntity<Object> deleteEmployeeByEmpId(@PathVariable("emp_id") Long emp_id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeService.getEmployeeByEmpId(emp_id);
        if (employee.isEmpty()) {
            LOGGER.info("Requested with invalid empId: " + emp_id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        employeeService.deleteEmployeeByEmpId(emp_id);
        LOGGER.info("Deleted Employee Record with empId: " + emp_id);
        return ResponseEntity.of(Optional.of(employee));
    }

    @DeleteMapping("/employee")
    public ResponseEntity<Object> deleteAllEmployee() {
        Optional<List<Employee>> listEmp = employeeService.getAllEmployeesRecord();
        if (listEmp.isEmpty()) {
            LOGGER.info("No Employees Found...");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.employeeService.deleteAll();
        LOGGER.info("Deleted All Employee records");
        return ResponseEntity.of(Optional.of(listEmp));
    }
}
