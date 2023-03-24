package com.emp_management.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_management.model.Employee;
import com.emp_management.repository.EmployeeRepository;

@Service

public class EmployeeService {

	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> findAll(){
		
		return repo.findAll();
		
	}
	
	public void save(Employee employee) {
		repo.save(employee);
		
	}
	
	public Employee get(int id) {
		return repo.findById(id).get();
		
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<Employee> fingByKey(String key){
		return repo.findByKey(key);
	}
}
