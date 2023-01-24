package com.springboot.project.service;

import com.springboot.project.entity.Employee;
import com.springboot.project.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee emp);
}
