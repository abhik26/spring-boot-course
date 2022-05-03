package com.example.springboot.dao;

import java.util.List;

import com.example.springboot.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(long employeeId);
	
	long saveOrUpdate(Employee employee);
	
	boolean deleteById(long employeeId);
}
