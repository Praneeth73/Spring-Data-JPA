package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// constructor injection of DAO class
	private EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepo) {
		employeeRepo = theemployeeRepo;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee findId(int theId) {

		Optional<Employee> result = employeeRepo.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("did not find employee Id -- " + theId);
		}
		return theEmployee;
	}

	@Override
	public void update(Employee theemployee) {

		employeeRepo.save(theemployee);

	}

	@Override
	public void delete(int theId) {

		employeeRepo.deleteById(theId);

	}

}
