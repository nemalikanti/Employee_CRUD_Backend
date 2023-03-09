package com.emp_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	 
}