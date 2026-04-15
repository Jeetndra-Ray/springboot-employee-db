package com.employee.employeeapi.repository;

import com.employee.employeeapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You get CRUD methods automatically:
    // save(), findById(), findAll(), deleteById(), etc.
}

