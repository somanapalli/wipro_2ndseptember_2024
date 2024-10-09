package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Employee;
import com.wipro.exception.EmployeeNotFoundException;
import com.wipro.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	  private EmployeeRepository repository;
	  
	
	@PostMapping("/api/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		return repository.save(employee);
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
	}
	
	@GetMapping("/api/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException
	{
		//   T get();
		Employee employee = repository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found with id: " + id));
	    return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PutMapping("/api/employees/{id}")
	public Employee updateEmployeeById(@PathVariable("id") Long id, @Valid @RequestBody Employee employee)
	{
		Employee updatedEmployee = repository.findById(id).get();
		
		updatedEmployee.setName(employee.getName());
		updatedEmployee.setRole(employee.getRole());
		
		return repository.save(updatedEmployee);
	}
	
	@DeleteMapping("/api/employees/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id)
	{
		repository.deleteById(id);
		return "employee with id " + id + " deleted successfully";
	}
	@GetMapping("/myaccount")
	public String getAccount()
	{
		return "welcome to my account";
	}
	@GetMapping("/mybalance")
	public String getBalance()
	{
		return " my balance is 10cr";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "home page";
	}
}
