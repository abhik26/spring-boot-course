package com.example.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private final EntityManager em;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(long employeeId) {
		Session currentSession = em.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, employeeId);
		
		return employee;
	}

	@Override
	public long saveOrUpdate(Employee employee) {
		Session currentSession = em.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
		return employee.getId();
	}

	@Override
	public boolean deleteById(long employeeId) {
		boolean deleted = false;
		Session currentSession = em.unwrap(Session.class);
		
		int deleteCount = currentSession.createQuery("delete from Employee where id = :employeeId")
				.setParameter("employeeId", employeeId).executeUpdate();
		
		if (deleteCount > 0) {
			deleted = true;
		}
		
		return deleted;
	}

}
