package com.luv2code.springboot.cruddemo.restcontroller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// inject employee dao
	@Autowired
	EmployeeService employeeService;

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employeeId/{employeeId}")
	public EntityModel<Employee> findEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findId(employeeId);
		// retrieve all users 
		EntityModel<Employee> model = new EntityModel<>(theEmployee);
		 
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getEmployees());
	 
		model.add(linkTo.withRel("all-Empoyees"));
	 
		return model;
		
	}

	@PostMapping("/newemployee")
	public Employee newEmployee(@RequestBody Employee theEmpolyee) {
		theEmpolyee.setId(0);
		employeeService.update(theEmpolyee);
		return theEmpolyee;
	}
	
	@DeleteMapping("/Employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		 employeeService.delete(employeeId);
		 return "Delete the Employee with ID --> " +employeeId;
		 
	}
	
	
	
	
	
	

}
