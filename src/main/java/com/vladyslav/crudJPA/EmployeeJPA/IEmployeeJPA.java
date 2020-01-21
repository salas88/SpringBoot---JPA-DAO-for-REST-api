package com.vladyslav.crudJPA.EmployeeJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladyslav.crudJPA.Entity.Employee;

public interface IEmployeeJPA  extends JpaRepository<Employee, Integer>{

}
