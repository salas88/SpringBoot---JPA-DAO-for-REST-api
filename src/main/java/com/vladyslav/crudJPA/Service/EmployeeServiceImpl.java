package com.vladyslav.crudJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladyslav.crudJPA.EmployeeJPA.IEmployeeJPA;
import com.vladyslav.crudJPA.Entity.Employee;

@Service
public class EmployeeServiceImpl implements IService {
	
	private IEmployeeJPA employeeJPA;
	
	// if only one constructor - @Autowired can be not write
	public EmployeeServiceImpl(IEmployeeJPA theIEmployeeJPA) {
		
		employeeJPA = theIEmployeeJPA;
		
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeJPA.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeJPA.findById(theId);
		
		Employee tempEmployee = null;
		
		if(result.isPresent())
			tempEmployee = result.get();
		else
			throw new RuntimeException("not found employee by id " + theId);
		
		return tempEmployee;
	}

	@Override
	public void deleteById(int theId) {
		
		employeeJPA.deleteById(theId);;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeJPA.save(theEmployee);

	}

}
