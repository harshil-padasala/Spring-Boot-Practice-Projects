package com.springboot.project.error;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
