package com.springboot.project.repository;

import com.springboot.project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method for finding EmployeeId by empId
    public Employee findByEmpId(Integer id);
}
