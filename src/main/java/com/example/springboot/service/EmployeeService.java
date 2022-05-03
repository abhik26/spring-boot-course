package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(long employeeId);
	
	long saveOrUpdate(Employee employee);
	
	boolean deleteById(long employeeId);
}
