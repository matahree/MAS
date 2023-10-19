package com.example.mas5demo.repository;

import com.example.mas5demo.model.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
