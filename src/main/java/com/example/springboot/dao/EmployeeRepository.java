package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springboot.entity.Employee;

@RepositoryRestResource(path="assets")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
