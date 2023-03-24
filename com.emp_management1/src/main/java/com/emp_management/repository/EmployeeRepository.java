package com.emp_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emp_management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Custom query
	 @Query(value = "select * from Employee e where e.name like %:key% or e.email like %:key%", nativeQuery = true)
	 List<Employee> findByKey(@Param("key") String key);
	
//	List<Employee> searchByName(String name);

}
