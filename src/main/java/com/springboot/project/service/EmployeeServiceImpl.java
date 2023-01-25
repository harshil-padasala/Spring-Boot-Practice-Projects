package com.springboot.project.service;

import com.springboot.project.entity.Employee;
import com.springboot.project.error.EmployeeNotFoundException;
import com.springboot.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Optional<Employee> getEmployeeByEmpId(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findByEmpId(id);
    }

    @Override
    public Optional<List<Employee>> getAllEmployeesRecord() {
        return Optional.of(employeeRepository.findAll());
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployeeByEmpId(Long id) throws EmployeeNotFoundException {
        Optional<Employee> emp = employeeRepository.findByEmpId(id);
        employeeRepository.delete(emp.get());
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
