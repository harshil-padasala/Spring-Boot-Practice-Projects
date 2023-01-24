package com.springboot.project.service;

import com.springboot.project.entity.Employee;
import com.springboot.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employee getEmployeeByEmpId(Integer id) {
        return employeeRepository.findByEmpId(id);
    }

    @Override
    public List<Employee> getAllEmployeesRecord() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }
}
