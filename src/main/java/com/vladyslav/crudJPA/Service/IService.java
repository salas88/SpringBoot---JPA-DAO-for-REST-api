package com.vladyslav.crudJPA.Service;

import java.util.List;

import com.vladyslav.crudJPA.Entity.Employee;

public interface IService {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void deleteById(int theId);
	
	void save(Employee theEmployee);
	
	
}
