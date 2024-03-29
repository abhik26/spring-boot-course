package com.example.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springboot.entity.Employee;

@RepositoryRestResource(path="employees") // This annotation is used to customize the spring data rest api path for the given repository.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findAllByOrderByFirstNameAsc();
}
