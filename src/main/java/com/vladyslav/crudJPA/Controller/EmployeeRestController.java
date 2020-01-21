package com.vladyslav.crudJPA.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladyslav.crudJPA.Entity.Employee;
import com.vladyslav.crudJPA.Service.IService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private IService iService;
	
	public EmployeeRestController(IService theIService) {
		
		iService = theIService;
		
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){ 
		
		return iService.findAll(); 
		
	}
	
	@GetMapping("/employees/{theId}")
	public Employee findById(@PathVariable int theId) { 
		
		return iService.findById(theId); 
		
		}
	
	@PostMapping("/employees")
	public String addNewAmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		iService.save(theEmployee);
		
		return "Hello " + theEmployee.getFirstName() + " " + theEmployee.getLastName();
		
	}
	
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody Employee theEmployee) {
		
		iService.save(theEmployee);
		
		return "Update Employee wirh id " + theEmployee.getId();
		
	}
	
	@DeleteMapping("/employees/{theId}")
	public String deleteEmployee(@PathVariable int theId) {
		iService.deleteById(theId);
		
		return "Employee with id " + theId  + " was delete";
	}

}
