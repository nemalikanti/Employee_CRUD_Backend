package com.emp_management.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp_management.model.Employee;
import com.emp_management.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService serv;
	
	@GetMapping("/employee")
	@CrossOrigin(origins = "http://localhost:4200" )
	public List<Employee> findAll() {
			return serv.findAll();
	    
	}



	@GetMapping("/employee/{id}")
	@CrossOrigin(origins = "http://localhost:4200" )
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
	    try {
	        Employee employee = serv.get(id);
	        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}


	@PostMapping("/employee")
	@CrossOrigin(origins = "http://localhost:4200" )
	public void add(@RequestBody Employee employee) {
	    serv.save(employee);
	}

	
	@PutMapping("/employee/{id}")
	@CrossOrigin(origins = "http://localhost:4200" )
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
	    try {
	        @SuppressWarnings("unused")
			Employee existemployee = serv.get(id);
	        serv.save(employee);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}



	@DeleteMapping("/employee/{id}")
	@CrossOrigin(origins = "http://localhost:4200" )
	public void delete(@PathVariable Integer id) {
	    serv.delete(id);
	}
}