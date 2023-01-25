package com.springboot.project.service;

import com.springboot.project.entity.Employee;
import com.springboot.project.error.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee emp);

    Optional<Employee> getEmployeeByEmpId(Long id) throws EmployeeNotFoundException;

    Optional<List<Employee>> getAllEmployeesRecord();

    void updateEmployee(Employee emp);

    void deleteEmployeeByEmpId(Long id) throws EmployeeNotFoundException;

    void deleteAll();
}
