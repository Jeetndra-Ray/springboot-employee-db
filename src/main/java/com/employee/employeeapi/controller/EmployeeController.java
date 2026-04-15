package com.employee.employeeapi.controller;

import com.employee.employeeapi.entity.Employee;
import com.employee.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Create Employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // Get all Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existing = service.getEmployeeById(id);
        existing.setName(employee.getName());
        existing.setSex(employee.getSex());
        existing.setRole(employee.getRole());
        existing.setDepartment(employee.getDepartment());
        existing.setDateOfJoining(employee.getDateOfJoining());
        existing.setDateOfBirth(employee.getDateOfBirth());
        existing.setSalary(employee.getSalary());
        existing.setYearsOfExperience(employee.getYearsOfExperience());
        return service.saveEmployee(existing);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}
