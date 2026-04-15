package com.employee.employeeapi.service;

import com.employee.employeeapi.entity.Employee;
import com.employee.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Create or Update Employee
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get Employee by ID
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found with id " + id)
        );
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}