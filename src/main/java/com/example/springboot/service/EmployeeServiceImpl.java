package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.EmployeeRepository;
import com.example.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
//	private final EmployeeDAO employeeDAO;
	private final EmployeeRepository employeeRepository;
	
//	@Autowired
//	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
//		this.employeeDAO = employeeDAO;
//	}
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

//	@Override
//	@Transactional
//	public List<Employee> findAll() {
//		return employeeDAO.findAll();
//	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

//	@Override
//	@Transactional
//	public Employee findById(long employeeId) {
//		return employeeDAO.findById(employeeId);
//	}
	
	@Override
	public Employee findById(long employeeId) {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find employee with id - " + employeeId);
		}
		
		return employee;
	}

//	@Override
//	@Transactional
//	public long saveOrUpdate(Employee employee) {
//		return employeeDAO.saveOrUpdate(employee);
//	}
	
	@Override
	public long saveOrUpdate(Employee employee) {
		employee.setId(employeeRepository.save(employee).getId());
		return employee.getId();
	}

//	@Override
//	@Transactional
//	public boolean deleteById(long employeeId) {
//		return employeeDAO.deleteById(employeeId);
//	}
	
	@Override
	public boolean deleteById(long employeeId) {
		try {
			employeeRepository.deleteById(employeeId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Employee> findAllByOrderByFirstNameAsc() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

}
