package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
