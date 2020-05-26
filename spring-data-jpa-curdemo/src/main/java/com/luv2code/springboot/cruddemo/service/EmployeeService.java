package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findId(int theId);
	public void update(Employee theEmployee);
	public void delete(int theId);
	
}
