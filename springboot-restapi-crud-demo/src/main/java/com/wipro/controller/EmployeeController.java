package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	  private EmployeeRepository repository;
	  
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return repository.save(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id)
	{
		return repository.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee)
	{
		Employee updatedEmployee = repository.findById(id).get();
		
		updatedEmployee.setName(employee.getName());
		updatedEmployee.setRole(employee.getRole());
		
		return repository.save(updatedEmployee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id)
	{
		repository.deleteById(id);
		return "employee with id " + id + " deleted successfully";
	}
	
}
