package com.example.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("FROM Employee");
		return query.getResultList();
	}

	@Override
	public Employee findById(long employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public long saveOrUpdate(Employee employee) {
		entityManager.merge(employee);
		return employee.getId();
	}

	@Override
	public boolean deleteById(long employeeId) {
		boolean deleted = false;
		int rowsAffected = entityManager.createQuery("delete from Employee where id = :employeeId")
				.setParameter("employeeId", employeeId).executeUpdate();
		
		if (rowsAffected > 0) {
			deleted = true; 
		}
		
		return deleted;
	}

}
